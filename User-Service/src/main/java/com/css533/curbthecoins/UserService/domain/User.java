package com.css533.curbthecoins.UserService.domain;

public class User {

    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String inviteCode;
    private Integer partnerId;

    public User(Integer userId, String firstname, String lastName, String email, String password, Integer partnerId, String inviteCode){
        this.userId = userId;
        this.firstName = firstname;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.partnerId = partnerId;
        this.inviteCode = inviteCode;
    }

    public String getPassword() {
        return password;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getPartnerId() {
        return partnerId;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setUserId(Integer userId) {

        this.userId = userId;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }
}
