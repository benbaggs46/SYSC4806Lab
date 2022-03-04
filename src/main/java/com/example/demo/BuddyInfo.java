package com.example.demo;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
public class BuddyInfo {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name, phoneNumber, address;

    public BuddyInfo(){}

    public BuddyInfo(String name, String phoneNumber, String address){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    @ManyToOne
    private AddressBook addressBook;

    public void setId(Long id){
        this.id = id;
    }

    public AddressBook getAddressBook() {
        return addressBook;
    }

    public void setAddressBook(AddressBook addressBook){
        this.addressBook = addressBook;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return address;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String toString(){
        return "Name: " + name +
                ", Phone Number: " + phoneNumber +
                ", Address: " + address;
    }

    public Long getId() {
        return id;
    }
}

