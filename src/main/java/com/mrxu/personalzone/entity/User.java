package com.mrxu.personalzone.entity;

import java.util.Date;

public class User {
    private int userID;         //ID号，主键
    private String userAccount; //登录名
    private String userPwd;     //密码
    private String userSName;   //用户网名
    private String userName;    //姓名
    private String userSex;       //用户性别，0代表‘男’，1代表‘女’
    private int userAge;        //用户年龄
    private Date userBirth;     //用户生日
    private String userEmail;   //用户邮箱
    private String userPhoto;   //用户头像路径
    private String userMobil;   //用户手机号

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserSName() {
        return userSName;
    }

    public void setUserSName(String userSName) {
        this.userSName = userSName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public Date getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(Date userBirth) {
        this.userBirth = userBirth;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getUserMobil() {
        return userMobil;
    }

    public void setUserMobil(String userMobil) {
        this.userMobil = userMobil;
    }

    public User() {
    }

    public User(int userID, String userAccount, String userPwd, String userSName, String userName, String userSex, int userAge, Date userBirth, String userEmail, String userPhoto, String userMobil) {
        this.userID = userID;
        this.userAccount = userAccount;
        this.userPwd = userPwd;
        this.userSName = userSName;
        this.userName = userName;
        this.userSex = userSex;
        this.userAge = userAge;
        this.userBirth = userBirth;
        this.userEmail = userEmail;
        this.userPhoto = userPhoto;
        this.userMobil = userMobil;
    }

    public User(String userAccount, String userPwd, String userName,String userPhoto, String userSex, String userMobil) {
        this.userAccount = userAccount;
        this.userPwd = userPwd;
        this.userName = userName;
        this.userPhoto = userPhoto;
        this.userSex = userSex;
        this.userMobil = userMobil;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", userAccount='" + userAccount + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userSName='" + userSName + '\'' +
                ", userName='" + userName + '\'' +
                ", userSex=" + userSex +
                ", userAge=" + userAge +
                ", userBirth=" + userBirth +
                ", userEmail='" + userEmail + '\'' +
                ", userPhoto='" + userPhoto + '\'' +
                ", userMobil='" + userMobil + '\'' +
                '}';
    }
}
