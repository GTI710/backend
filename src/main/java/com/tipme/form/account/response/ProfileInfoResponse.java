package com.tipme.form.account.response;

import com.tipme.model.Account;
import com.tipme.utils.DateFormatter;
import org.springframework.http.HttpStatus;

import java.util.List;

public class ProfileInfoResponse {

    private static final String INFO_FAILED = "A problem has been encountered.";
    private static final String INFO_OK = "OK";

    private HttpStatus status;
    private String message;
    private Integer idAccount;
    private String email;
    private String username;
    private String profileDescription;
    private String dateBirthday;
    private String dateCreated;
    private String imageProfile;
    private Integer followersCount;
    private Integer followingCount;
    private String gender;
    private Boolean isFollowing;

    public ProfileInfoResponse() {
    }

    public ProfileInfoResponse ok(Account account, Boolean isFollowing) {
        this.status = HttpStatus.OK;
        this.message = INFO_OK;

        this.idAccount = account.getIdAccount();
        this.email = account.getEmail();
        this.username = account.getUsername();
        this.profileDescription = account.getProfileDescription();
        this.dateBirthday = DateFormatter.DateToString(account.getDateBirthday());
        this.dateCreated = DateFormatter.DateToString(account.getDateCreated());
        this.imageProfile = account.getImageProfile();
        this.followersCount = account.getFollowersCount();
        this.followingCount = account.getFollowingCount();
        this.gender = account.getGender();
        this.isFollowing = isFollowing;
        return this;
    }

    public ProfileInfoResponse failed() {
        status = HttpStatus.INTERNAL_SERVER_ERROR;
        message = INFO_FAILED;
        return this;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

    public String getDateBirthday() {
        return dateBirthday;
    }

    public void setDateBirthday(String dateBirthday) {
        this.dateBirthday = dateBirthday;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getImageProfile() {
        return imageProfile;
    }

    public void setImageProfile(String imageProfile) {
        this.imageProfile = imageProfile;
    }

    public Integer getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;
    }

    public Integer getFollowingCount() {
        return followingCount;
    }

    public void setFollowingCount(Integer followingCount) {
        this.followingCount = followingCount;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean getFollowing() {
        return isFollowing;
    }

    public void setFollowing(Boolean following) {
        isFollowing = following;
    }
}
