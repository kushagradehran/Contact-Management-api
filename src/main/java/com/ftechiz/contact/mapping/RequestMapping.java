package com.ftechiz.contact.mapping;

import com.ftechiz.contact.entity.AddressEntity;
import com.ftechiz.contact.entity.ContactEntity;
import com.ftechiz.contact.model.ContactRequest;

public class RequestMapping {

    public static ContactEntity buildContactRequest(ContactRequest contactRequest)
    {
        return ContactEntity.builder()
                .fullName(contactRequest.getFullName())
                .dob(contactRequest.getDob())
                .addressEntity(buildAddress(contactRequest))
                .build();
    }
    public static AddressEntity buildAddress(ContactRequest contactRequest)
    {
        return AddressEntity.builder()
                .city(contactRequest.getAddress().getCity())
                .zipCode(contactRequest.getAddress().getZipCode())
                .build();
    }
}
