package com.ftechiz.contact.repository;

import com.ftechiz.contact.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity,Integer> {
    @Query( value = "SELECT * FROM contact WHERE zip = ?1", nativeQuery = true)
    List<ContactEntity> findContactByZipCode(String zipCode);
}