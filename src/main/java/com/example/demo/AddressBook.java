package com.example.demo;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Component
public class AddressBook{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, mappedBy = "addressBook")
    private List<BuddyInfo> buddies;

    public AddressBook(){
        buddies = new ArrayList<>();
    }

    public void addBuddy(BuddyInfo buddy){
        buddy.setAddressBook(this);
        buddies.add(buddy);
    }

    public void removeBuddy(BuddyInfo buddyInfo){
        buddies.remove(buddyInfo);
    }

    public void clear(){
        buddies.clear();
    }

    public int getSize(){
        return buddies.size();
    }

    public List<BuddyInfo> getBuddies(){
        return buddies;
    }

    public String toString(){
        String str = "Address Book " + id;
        for(BuddyInfo b: buddies){
            str += b.toString();
        }
        return str;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return id;
    }
}

