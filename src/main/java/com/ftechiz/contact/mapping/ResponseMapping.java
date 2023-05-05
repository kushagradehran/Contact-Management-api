package com.ftechiz.contact.mapping;

import com.ftechiz.contact.entity.ContactEntity;
import com.ftechiz.contact.model.AddressResponse;
import com.ftechiz.contact.model.ContactResponse;

import java.util.ArrayList;
import java.util.List;

public class ResponseMapping {

    public static ContactResponse buildContactResponse(ContactEntity request) {
        return ContactResponse.builder()
                .contactId(request.getContactId())
                .fullName(request.getFullName())
                .dob(request.getDob())
                .address(AddressResponse.builder()
                        .city(request.getAddressEntity().getCity())
                        .zipCode(request.getAddressEntity().getZipCode())
                        .build())
                .build();
    }
    public static List<ContactResponse> buildContactListResponses(List<ContactEntity> list) {
        ContactResponse response = null;
        List<ContactResponse> response1 = new ArrayList<>();
        for (ContactEntity list1: list) {
          response=  ContactResponse.builder()
                    .contactId(list1.getContactId())
                    .dob(list1.getDob())
                    .fullName(list1.getFullName())
                    .address(AddressResponse.builder()
                            .city(list1.getAddressEntity().getCity())
                            .zipCode(list1.getAddressEntity().getZipCode())
                            .build())
                    .build();
         response1.add(response);
        }
        return  response1;
    }
}
