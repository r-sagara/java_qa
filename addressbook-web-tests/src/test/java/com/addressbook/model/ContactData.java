package com.addressbook.model;

public class ContactData {
    private final String firstName;
    private String middleName;
    private String lastName;
    private String nickName;
    private String photo;
    private String title;
    private String company;
    private String address;

    private String phoneHome;
    private String phoneMobile;
    private String phoneWork;
    private String fax;

    private String email;
    private String email2;
    private String email3;
    private String homepage;

    private String birthday;
    private String anniversary;
    private String group;

    private String addressSecondary;
    private String phoneHomeSecondary;
    private String notes;

    public ContactData(String firstName, String lastName, String phoneHome, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        //this.photo = photo;
        this.phoneHome = phoneHome;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoto() {
        return photo;
    }

    public String getPhoneHome() {
        return phoneHome;
    }

    public String getEmail() {
        return email;
    }
}
