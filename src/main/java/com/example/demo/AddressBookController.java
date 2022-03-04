package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AddressBookController {
    @Autowired
    private AddressBookRepository repository;
    @Autowired
    private BuddyInfoRepository buddy_repository;

    @GetMapping(value={"/addressBooks", "/"})
    public String getAddressBooks(Model model) {
        model.addAttribute("addressBooks", repository.findAll());
        model.addAttribute("formData", new BuddyFormData());
        return "index";
    }

    @GetMapping("addressBooks/{id}")
    public String showAddressBook(@PathVariable("id") Long id, Model model) {
        AddressBook book = repository.findById(id).get();
        model.addAttribute("addressBook", book);
        model.addAttribute("formData", new BuddyFormData());
        return "show";
    }

    @GetMapping(value={"/addressBooks/new", "/new"})
    public String createAddressBook() {
        AddressBook addressBook = new AddressBook();
        repository.save(addressBook);

        return "redirect:/addressBooks/" + addressBook.getId();
    }

    @PostMapping("/addressBooks/{id}/edit")
    public String addOrRemoveBuddy(@PathVariable("id") Long id, @RequestParam("action") String action, BuddyFormData formData) {
        AddressBook addressBook = repository.findById(id).get();
        if(action.equals("Add")) {
            BuddyInfo buddy = new BuddyInfo(formData.getName(), formData.getPhoneNumber(), formData.getAddress());
            addressBook.addBuddy(buddy);
            buddy_repository.save(buddy);

        }
        if(action.equals("Remove")){
            List<BuddyInfo> buddies = buddy_repository.findByNameAndPhoneNumber(formData.getName(), formData.getPhoneNumber());
            for(BuddyInfo buddy: buddies)
            {
                addressBook.removeBuddy(buddy);
                buddy_repository.delete(buddy);
            }
        }
        repository.save(addressBook);
        return "redirect:/addressBooks/" + addressBook.getId();
    }
}
