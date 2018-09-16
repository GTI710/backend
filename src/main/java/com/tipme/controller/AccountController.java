package com.tipme.controller;

import com.tipme.form.account.request.*;
import com.tipme.form.account.response.*;
import com.tipme.form.account.response.DeleteResponse;
import com.tipme.form.account.response.Login.AbstractLoginResponse;
import com.tipme.form.account.response.Login.AbstractLogoutResponse;
import com.tipme.form.account.response.UpdateResponse;
import com.tipme.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController("AccountController")
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    /**
     * Login with a username and a password
     * @param loginRequest
     * @return LoginResponse
     */
    @PostMapping("/login")
    public ResponseEntity<AbstractLoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {

        AbstractLoginResponse loginResponse = accountService.login(loginRequest);
        return ResponseEntity.status(loginResponse.getStatus()).body(loginResponse);
    }

    /**
     * Logout of the application
     * @param token
     * @return LogoutResponse
     */
    @PostMapping("/logout")
    public ResponseEntity<AbstractLogoutResponse> logout(@RequestHeader("Token") String token) {

        AbstractLogoutResponse logoutResponse = accountService.logout(token);
        return ResponseEntity.status(logoutResponse.getStatus()).body(logoutResponse);
    }

    /**
     * Create an account
     * @param createRequest
     * @return CreateResponse
     */
    @PostMapping("")
    public ResponseEntity<?> create(@Valid @RequestBody CreateRequest createRequest) {

        CreateResponse createResponse = accountService.create(createRequest);
        return ResponseEntity.status(createResponse.getStatus()).body(createResponse);
    }

    /**
     * Get logged user information
     * @param token
     * @return InfoResponse
     */
    @GetMapping("")
    public ResponseEntity<?> getInfo(@RequestHeader("Token") String token) {

        InfoResponse infoResponse = accountService.getInfo(token);
        return ResponseEntity.status(infoResponse.getStatus()).body(infoResponse);
    }

    /**
     * Reset a user password
     * @param token
     * @param resetPasswordRequest
     * @return ResetPasswordResponse
     */
    @PostMapping("/password")
    public ResponseEntity<?> resetPassword(@RequestHeader("Token") String token, @Valid @RequestBody ResetPasswordRequest resetPasswordRequest) {

        ResetPasswordResponse rpr = accountService.resetPassword(token, resetPasswordRequest);
        return ResponseEntity.status(rpr.getStatus()).body(rpr);
    }

    @PostMapping("/confirm")
    public ResponseEntity<?> confirmPassword(@RequestHeader("Token") String token, @Valid @RequestBody ConfirmPasswordRequest confirmPasswordRequest) {

        ConfirmPasswordResponse cpr = accountService.resetPassword(token, confirmPasswordRequest);
        return ResponseEntity.status(cpr.getStatus()).body(cpr);
    }

    /**
     * Update an account via his username
     * @param token
     * @param username
     * @param updatedAccount
     * @return UpdateResponse
     */
    @PutMapping("/{username}")
    public ResponseEntity<?> updateAccountByUsername(@RequestHeader("Token") String token, @PathVariable("username") String username, @Valid @RequestBody UpdateRequest updatedAccount) {

        UpdateResponse updateResponse = accountService.modify(token, username, updatedAccount);
        return ResponseEntity.status(updateResponse.getStatus()).body(updateResponse);
    }

    /**
     * Delete an account via his username and password
     * @param token
     * @param username
     * @return DeleteResponse
     */
    @DeleteMapping("/{username}")
    public ResponseEntity<?> deleteAccountByUsername(@RequestHeader("Token") String token, @PathVariable("username") String username) {

        DeleteResponse deleteResponse = accountService.delete(token, username);
        return ResponseEntity.status(deleteResponse.getStatus()).body(deleteResponse);
    }
}
