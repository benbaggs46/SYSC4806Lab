package com.example.demo;

public class BuddyFormData {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address){
        this.address = address;
    }

    private String name;
    private String phoneNumber;
    private String address;

    public String getAddress() {
        return address;
    }
}
