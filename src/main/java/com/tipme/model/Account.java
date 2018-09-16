package com.tipme.model;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import java.util.Date;

@Indexed
@Entity
@Table(name = "account")
public class Account {


    @Id

    @SequenceGenerator(name = "account_idaccount_seq", sequenceName = "account_idaccount_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_idaccount_seq")
    @Column(name = "idaccount")
    private Integer idAccount;

    @Field
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Field
    @Column(name = "username")
    private String username;

    @Column(name = "profiledescription")
    private String profileDescription;

    @Column(name = "datebirthday")
    private Date dateBirthday;

    @Column(name = "datecreation")
    private Date dateCreated;

    @Column(name = "imageprofile")
    private String imageProfile;

    @Column(name = "followerscount")
    private Integer followersCount;

    @Column(name = "followingcount")
    private Integer followingCount;

    @Column(name = "gender")
    private String gender;

    public Account() {
    }

    public Account(Integer idAccount, String email, String password, String username,
                   String profileDescription, Date dateBirthday, Date dateCreated
            , String imageProfile, Integer followersCount, Integer followingCount, String gender) {
        this.idAccount = idAccount;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Date getDateBirthday() {
        return dateBirthday;
    }

    public void setDateBirthday(Date dateBirthday) {
        this.dateBirthday = dateBirthday;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
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
