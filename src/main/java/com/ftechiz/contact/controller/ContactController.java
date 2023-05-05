package com.ftechiz.contact.controller;

import com.ftechiz.contact.model.ContactRequest;
import com.ftechiz.contact.model.ContactResponse;
import com.ftechiz.contact.service.ContactService;
import java.util.Collections;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping(value = "/createContact")
    public ResponseEntity<Object> createContactDetail(@Valid @RequestBody ContactRequest contact ) {
        ContactResponse response = contactService.createContact(contact);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
    @GetMapping(value = "/findAllContact")
    public ResponseEntity<List<ContactResponse>> findAllContacts() {

        List<ContactResponse> getAllContact = contactService.allContact();
        if (getAllContact.isEmpty()) {
            return ResponseEntity.ok().body(Collections.emptyList());
        } else {
            return ResponseEntity.ok().body(getAllContact);
        }
    }

    @GetMapping("/findByZipCode/{zipCode}")
    public ResponseEntity<List<ContactResponse>> findByZipCode(@PathVariable("zipCode") String zipCode) {
        List<ContactResponse> findContactByZip = contactService.findContactByZipCode(zipCode);
        if (findContactByZip.isEmpty()) {
            return ResponseEntity.ok().body(Collections.emptyList());
        }
        return (new ResponseEntity(findContactByZip, HttpStatus.OK)) ;
    }
}
