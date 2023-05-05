package com.ftechiz.contact.entity;

import lombok.*;

import javax.persistence.*;
@Data
@Builder
@Embeddable
@Table(name = "address")
@RequiredArgsConstructor

public class AddressEntity {
    @Column(name = "city")
    private String city;

    @Column(name = "zip")
    private String zipCode;

    public AddressEntity(String city, String zipCode) {
        this.city = city;
        this.zipCode = zipCode;
    }
}
