package com.ftechiz.contact.service;

import com.ftechiz.contact.model.ContactRequest;
import com.ftechiz.contact.model.ContactResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactService {

    public ContactResponse createContact(ContactRequest contact);

    public List<ContactResponse> allContact();

    public List<ContactResponse> findContactByZipCode(String zipCode);
}
