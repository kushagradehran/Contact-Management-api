package com.ftechiz.contact.service.impl;

import com.ftechiz.contact.entity.ContactEntity;
import com.ftechiz.contact.model.ContactRequest;
import com.ftechiz.contact.model.ContactResponse;
import com.ftechiz.contact.repository.ContactRepository;
import com.ftechiz.contact.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ftechiz.contact.mapping.RequestMapping.buildContactRequest;
import static com.ftechiz.contact.mapping.ResponseMapping.buildContactResponse;
import static com.ftechiz.contact.mapping.ResponseMapping.buildContactListResponses;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public ContactResponse createContact(ContactRequest contact) {
        final ContactEntity request = contactRepository.save(buildContactRequest(contact));
        final ContactResponse response = buildContactResponse(request);
        return response;
    }

    @Override
    public List<ContactResponse> allContact() {
        List<ContactEntity> getAllContact = contactRepository.findAll();
        final List<ContactResponse> responses = buildContactListResponses(getAllContact);
        return responses;
    }

    @Override
    public List<ContactResponse> findContactByZipCode(String zipCode) {
        final List<ContactEntity> findContactByZipCode = contactRepository.findContactByZipCode(zipCode);
        final List<ContactResponse> responses = buildContactListResponses(findContactByZipCode);
        return responses;
    }
}
