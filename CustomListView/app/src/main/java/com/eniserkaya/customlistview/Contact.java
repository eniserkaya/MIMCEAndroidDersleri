package com.eniserkaya.customlistview;

/**
 * Created by eniserkaya on 4.12.2017.
 */

public class Contact {

    private boolean gender;
    private String userName;
    private String phoneNumber;

    public Contact(boolean gender, String userName, String phoneNumber) {
        this.gender = gender;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
