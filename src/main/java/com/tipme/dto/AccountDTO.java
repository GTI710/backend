package com.tipme.dto;


public class AccountDTO {

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

    public AccountDTO() {
    }

    public AccountDTO(Integer idAccount, String email, String username,
                      String profileDescription, String dateBirthday, String dateCreated
            , String imageProfile, Integer followersCount, Integer followingCount, String gender) {
        this.idAccount = idAccount;
        this.email = email;
        this.username = username;
        this.profileDescription = profileDescription;
        this.dateBirthday = dateBirthday;
        this.dateCreated = dateCreated;
        this.imageProfile = imageProfile;
        this.followersCount = followersCount;
        this.followingCount = followingCount;
        this.gender = gender;
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
}
