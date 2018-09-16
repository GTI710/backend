package com.tipme.service;

import com.tipme.form.account.request.*;
import com.tipme.form.account.response.*;
import com.tipme.form.account.response.Login.*;
import com.tipme.form.account.response.UpdateResponse;
import com.tipme.form.validator.AccountValidator;
import com.tipme.model.*;
import com.tipme.repository.*;
import com.tipme.utils.DateFormatter;
import com.tipme.utils.session.SessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class AccountService {

    private static final Logger logger = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    private AccountRepository accountRepository;

    private BCryptPasswordEncoder encoder; // Encoder to encrypt the password

    /**
     * Constructor, initializes the password encoder
     */
    public AccountService() {
        encoder = new BCryptPasswordEncoder();
    }

    /**
     * Login an account
     * @param loginRequest
     * @return AbstractLoginResponse
     */
    public AbstractLoginResponse login(LoginRequest loginRequest) {

        // If one of the following attributes are null, do not call the DB
        if (loginRequest.getUsername() == null || loginRequest.getPassword() == null) {
            return new LoginFailedResponse();
        }

        // Fetch the account by username
        Account account = accountRepository.findByUsernameIgnoreCase(loginRequest.getUsername());

        // If the account does not exist
        if (account == null) {
            return new LoginFailedResponse();
        }

        // If the password does not match
        if (!encoder.matches(loginRequest.getPassword(), account.getPassword())) {
            return new LoginFailedResponse();
        }

        // Create a new session token for the user
        String token = SessionManager.getInstance().addSession(account);

        // Create a new account with useful information only
        Account newAccount = new Account(
                account.getIdAccount(),
                account.getEmail(),
                null,
                account.getUsername(),
                null,
                null,
                null,
                account.getImageProfile(),
                null,
                null,
                null
        );

        return new LoginSucceededResponse(
                newAccount,
                token
        );
    }

    /**
     * Logout an account
     * @param token
     * @return AbstractLogoutResponse
     */
    public AbstractLogoutResponse logout(String token) {

        Integer idAccount = SessionManager.getInstance().getAccountIdForToken(token);

        // If the user does not have a token, it's a server problem
        if (SessionManager.NO_SESSION.equals(idAccount)) {
            logger.error("A user based on a session token cannot be found.");
            return new LogoutFailedResponse();
        }

        // Fetch the account by idAccount
        Account account = accountRepository.findByIdAccount(idAccount);

        // If the account does not exist
        if (account == null) {
            return new LogoutFailedResponse();
        }

        // Remove the session token for the user
        SessionManager.getInstance().removeSession(token);

        return new LogoutSucceededResponse(
                account.getIdAccount(),
                account.getUsername()
        );
    }

    /**
     * Create an account
     * @param createRequest
     * @return
     */
    @Transactional
    public CreateResponse create(CreateRequest createRequest) {

        // If some inputs are missing
        if (!AccountValidator.isCreateRequestComplete(createRequest)) {
            return new CreateResponse().fieldsMissing();
        }

        // If the email is too long or doesn't respect the requirements
        if (!AccountValidator.isEmailValid(createRequest.getEmail())) {
            return new CreateResponse().invalidEmailFormat();
        }

        // If the username is too long or doesn't respect the requirements
        if (!AccountValidator.isUsernameValid(createRequest.getUsername())) {
            return new CreateResponse().invalidUsernameFormat();
        }

        // If the passwords do not match
        if (!createRequest.getPassword().equals(createRequest.getConfirmPassword())) {
            return new CreateResponse().wrongPasswords();
        }

        // If the password is too long or doesn't respect the requirements
        if(!AccountValidator.isPasswordLengthValid(createRequest.getPassword())){
            return new CreateResponse().invalidPasswordFormat();
        }

        // If the email is already taken
        if (accountRepository.findByEmailIgnoreCase(createRequest.getEmail()) != null) {
            return new CreateResponse().emailAlreadyUsed();
        }

        // If the username is already taken
        if (accountRepository.findByUsernameIgnoreCase(createRequest.getUsername()) != null) {
            return new CreateResponse().usernameAlreadyUsed();
        }

        // Convert the String to Date
        Date dateBirthday = DateFormatter.StringToDate(createRequest.getDateBirthday());

        // If the birthday date is null
        if (dateBirthday == null) {
            return new CreateResponse().invalidDateFormat();
        }

        // If the birthday date is less than 13 years old
        if (!AccountValidator.isDateBirthdayValid(dateBirthday)) {
            return new CreateResponse().invalidBirthday();
        }

        String token = "";
        Account newAccount = null;

        try {

            // Create the account
            newAccount = accountRepository.save(new Account(
                null,
                createRequest.getEmail(),
                encoder.encode(createRequest.getPassword()), // password encryption
                createRequest.getUsername(),
                null,
                dateBirthday,
                new Date(),
                null,
                0,
                0,
                createRequest.getGender()
             ));

            // Create a new session token for the user
            token = SessionManager.getInstance().addSession(newAccount);

        } catch (NullPointerException npe) {
            return new CreateResponse().failed();
        }

        return new CreateResponse().ok(newAccount, token);
    }

    /**
     * Fetch the information of the logged account
     * @param token
     * @return InfoResponse
     */
    public InfoResponse getInfo(String token) {

        Integer accountID = SessionManager.getInstance().getAccountIdForToken(token);

        // If the user does not have a token, it's a server problem
        if (SessionManager.NO_SESSION.equals(accountID)) {
            logger.error("A user based on a session token cannot be found.");
            return new InfoResponse().failed();
        }

        // If the session has expired
        if (!SessionManager.getInstance().isSessionValid(token)) {
            // Remove the session token for the user
            SessionManager.getInstance().removeSession(token);
            return new InfoResponse().sessionExpired();
        }

        // Fetch the account by idAccount
        Account account = accountRepository.findByIdAccount(accountID);

        // If the account can't be found, it's a server problem
        if (account == null) {
            logger.error("An account based on a session token cannot be found.");
            return new InfoResponse().failed();
        }

        // Create a new account with useful information only
        Account newAccount = new Account(
                account.getIdAccount(),
                account.getEmail(),
                null,
                account.getUsername(),
                account.getProfileDescription(),
                account.getDateBirthday(),
                null,
                account.getImageProfile(),
                null,
                null,
                account.getGender()
        );

        return new InfoResponse().ok(newAccount);
    }

    /**
     * Reset a password for an account
     * @param token
     * @param resetPasswordRequest
     * @return ResetPasswordResponse
     */
    public ResetPasswordResponse resetPassword(String token, ResetPasswordRequest resetPasswordRequest) {

        Integer accountID = SessionManager.getInstance().getAccountIdForToken(token);

        // If the user does not have a token, it's a server problem
        if (SessionManager.NO_SESSION.equals(accountID)) {
            logger.error("A user based on a session token cannot be found.");
            return new ResetPasswordResponse().failed();
        }

        // Fetch the account by idAccount
        Account account = accountRepository.findByIdAccount(accountID);

        // If the account cannot be found, it's a server problem
        if (account == null) {
            logger.error("An account based on a session token cannot be found.");
            return new ResetPasswordResponse().failed();
        }

        // Check if the old and the logged account passwords match
        Boolean passwordMatch = encoder.matches(resetPasswordRequest.getOldPassword(), account.getPassword());

        // If the old password is invalid
        if (!passwordMatch) {
            return new ResetPasswordResponse().wrongOldPassword();
        }

        // If the new password and the new confirm password do not match
        if (!resetPasswordRequest.getNewPassword().equals(resetPasswordRequest.getConfirmNewPassword())) {
            return new ResetPasswordResponse().wrongNewPasswords();
        }

        // If the password length is longer than 60 characters
        if(!AccountValidator.isPasswordLengthValid(resetPasswordRequest.getNewPassword())){
            return new ResetPasswordResponse().wrongNewPasswords();
        }

        // Set and save password
        account.setPassword(encoder.encode(resetPasswordRequest.getNewPassword()));
        accountRepository.save(account);

        return new ResetPasswordResponse().ok();
    }

    /**
     * Confirm a password, for example when a user deletes an account
     * or makes a big change in the application
     * @param token
     * @param confirmPasswordRequest
     * @return ConfirmPasswordResponse
     */
    public ConfirmPasswordResponse resetPassword(String token, ConfirmPasswordRequest confirmPasswordRequest) {

        Integer accountID = SessionManager.getInstance().getAccountIdForToken(token);

        // If the user does not have a token, it's a server problem
        if (SessionManager.NO_SESSION.equals(accountID)) {
            logger.error("A user based on a session token cannot be found.");
            return new ConfirmPasswordResponse().failed();
        }

        // Fetch the account by idAccount
        Account account = accountRepository.findByIdAccount(accountID);

        // If the account cannot be found, it's a server problem
        if (account == null) {
            logger.error("An account based on a session token cannot be found.");
            return new ConfirmPasswordResponse().failed();
        }

        // Check if the old and the logged account passwords match
        Boolean passwordMatch = encoder.matches(confirmPasswordRequest.getPassword(), account.getPassword());

        // If the old password is invalid
        if (!passwordMatch) {
            return new ConfirmPasswordResponse().wrongPassword();
        }

        return new ConfirmPasswordResponse().ok();
    }

    /**
     * Update an account
     * @param token
     * @param username
     * @param updatedAccount
     * @return UpdateResponse
     */
    @Transactional
    public UpdateResponse modify(String token, String username, UpdateRequest updatedAccount) {

        Integer idAccount = SessionManager.getInstance().getAccountIdForToken(token);

        // If the user does not have a token, it's a server problem
        if (SessionManager.NO_SESSION.equals(idAccount)) {
            logger.error("A user based on a session token cannot be found.");
            return new UpdateResponse().failed();
        }

        // Fetch the account by username
        Account account = accountRepository.findByUsernameIgnoreCase(username);

        // If the account is not found
        if (account == null) {
            return new UpdateResponse().notFound();
        }

        // If the inputs are empty
        if (!AccountValidator.isUpdateRequestComplete(updatedAccount)) {
            return new UpdateResponse().fieldsMissing();
        }

        // If the email is too long or doesn't respect the requirements
        if (!AccountValidator.isEmailValid(updatedAccount.getEmail())) {
            return new UpdateResponse().invalidEmailFormat();
        }

        // If the username is too long or doesn't respect the requirements
        if (!AccountValidator.isUsernameValid(updatedAccount.getUsername())) {
            return new UpdateResponse().invalidUsernameFormat();
        }

        // If the email has changed
        if (!updatedAccount.getEmail().equals(account.getEmail())) {
            // If the email is already taken
            if (accountRepository.findByEmailIgnoreCase(updatedAccount.getEmail()) != null) {
                return new UpdateResponse().emailAlreadyUsed();
            }
        }

        // If the username has changed
        if (!updatedAccount.getUsername().equals(account.getUsername()))
        {
            // If the username is already taken
            if (accountRepository.findByUsernameIgnoreCase(updatedAccount.getUsername()) != null) {
                return new UpdateResponse().usernameAlreadyUsed();
            }
        }

        // Convert the String to Date
        Date dateBirthday = DateFormatter.StringToDate(updatedAccount.getDateBirthday());

        // If the date is null
        if (dateBirthday == null) {
            return new UpdateResponse().invalidDateFormat();
        }

        // If the birthday date is less than 13 years old
        if (!AccountValidator.isDateBirthdayValid(dateBirthday)) {
            return new UpdateResponse().invalidBirthday();
        }

        try {

            // Update account
            Account modifiedAccount = accountRepository.save(new Account(
                    idAccount,
                    updatedAccount.getEmail(),
                    account.getPassword(),
                    updatedAccount.getUsername(),
                    updatedAccount.getProfileDescription(),
                    DateFormatter.StringToDate(updatedAccount.getDateBirthday()),
                    account.getDateCreated(),
                    account.getImageProfile(),
                    account.getFollowersCount(),
                    account.getFollowingCount(),
                    updatedAccount.getGender()
            ));

            // Save the changes
            accountRepository.save(modifiedAccount);

        } catch (NullPointerException npe) {
            return new UpdateResponse().fieldsMissing();
        }


        return new UpdateResponse().ok(account, token);
    }

    /**
     * Delete an account
     * @param token
     * @param username
     * @return DeleteResponse
     */
    @Transactional
    public DeleteResponse delete(String token, String username) {

        Integer idAccount = SessionManager.getInstance().getAccountIdForToken(token);

        // If the user does not have a token, it's a server problem
        if (SessionManager.NO_SESSION.equals(idAccount)) {
            logger.error("A user based on a session token cannot be found.");
            return new DeleteResponse().failed();
        }

        // Fetch the account by username
        Account account = accountRepository.findByUsernameIgnoreCase(username);

        // If the account is not found
        if (account == null) {
            return new DeleteResponse().notFound();
        }

        // If the logged account doesn't match the account to be deleted
        if (account.getIdAccount() != idAccount) {
            return new DeleteResponse().failed();
        }

        try {

            // Delete the account
            accountRepository.delete(idAccount);

            // Remove token
            SessionManager.getInstance().removeSession(token);

        } catch (NullPointerException npe) {
            return new DeleteResponse().failed();
        }

        return new DeleteResponse().ok();
    }
}
