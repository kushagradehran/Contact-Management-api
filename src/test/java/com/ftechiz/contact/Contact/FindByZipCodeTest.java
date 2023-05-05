package com.ftechiz.contact.Contact;

import com.ftechiz.contact.entity.AddressEntity;
import com.ftechiz.contact.entity.ContactEntity;
import com.ftechiz.contact.repository.ContactRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)

@SpringBootTest
public class FindByZipCodeTest {
    @Autowired
    private ContactRepository contactRepository;
    @Test
    public void testFindByZipCode() {
        // given
        AddressEntity addressEntity1 = new AddressEntity("xyz", "12345");
        ContactEntity contactEntity1 = new ContactEntity(1,"xyz", LocalDate.parse("1980-01-01"), addressEntity1);
        contactRepository.save(contactEntity1);

        AddressEntity addressEntity2 = new AddressEntity("xyz", "12345");
        ContactEntity contactEntity2 = new ContactEntity(2,"xyz", LocalDate.parse("1985-01-01"), addressEntity2);
        contactRepository.save(contactEntity2);
        AddressEntity addressEntity3 = new AddressEntity("abc", "67890");
        ContactEntity contactEntity3 = new ContactEntity(3,"xyz", LocalDate.parse("2000-01-01"), addressEntity3);
        contactRepository.save(contactEntity3);

        // when
        List<ContactEntity> contactsByZipCode = contactRepository.findContactByZipCode("12345");

        // Then
        assertEquals(2, contactsByZipCode.size());
        assertTrue(contactsByZipCode.contains(contactEntity1));
        assertTrue(contactsByZipCode.contains(contactEntity2));
        assertFalse(contactsByZipCode.contains(contactEntity3));
    }
}
