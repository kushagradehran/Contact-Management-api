package com.ftechiz.contact.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Builder
@Table(name = "contact")
@RequiredArgsConstructor
public class ContactEntity {
    @Id
    @Column(name = "contactId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contactId;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "dob")
    private LocalDate dob;

    @Embedded
    @Column(name = "address")
    private AddressEntity addressEntity;

    public ContactEntity(int contactId, String fullName, LocalDate dob, AddressEntity addressEntity) {
        this.contactId = contactId;
        this.fullName = fullName;
        this.dob = dob;
        this.addressEntity = addressEntity;
    }
}
