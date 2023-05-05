package com.ftechiz.contact.Contact;

import com.ftechiz.contact.entity.AddressEntity;
import com.ftechiz.contact.entity.ContactEntity;
import com.ftechiz.contact.repository.ContactRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ContactEntityTest {

    @Autowired
    private ContactRepository contactRepository;

    @Test
    public void testInsertContact() {
        AddressEntity addressEntity = new AddressEntity("xyz", "12345");
        ContactEntity contactEntity = new ContactEntity(1,"xyz", LocalDate.parse("2000-01-01"), addressEntity);

        ContactEntity savedContactEntity = contactRepository.save(contactEntity);
        assertNotNull(savedContactEntity.getContactId());
        assertEquals("xyz", savedContactEntity.getFullName());
        assertEquals(LocalDate.parse("2000-01-01"), savedContactEntity.getDob());
        assertEquals(addressEntity, savedContactEntity.getAddressEntity());

    }

    @Test
    public void testGetAllContacts() {

        AddressEntity addressEntity1 = new AddressEntity("Anytown", "12345");
        ContactEntity contactEntity1 = new ContactEntity(1,"John Doe", LocalDate.parse("1980-01-01"), addressEntity1);
        contactRepository.save(contactEntity1);

        AddressEntity addressEntity2 = new AddressEntity( "Anytown", "12345");
        ContactEntity contactEntity2 = new ContactEntity(2,"Jane Doe", LocalDate.parse("1985-01-01"), addressEntity2);
        contactRepository.save(contactEntity2);

        AddressEntity addressEntity3 = new AddressEntity( "Anycity", "67890");
        ContactEntity contactEntity3 = new ContactEntity(3,"Bob Smith", LocalDate.parse("1990-01-01"), addressEntity3);
        contactRepository.save(contactEntity3);

        List<ContactEntity> allContactEntities = contactRepository.findAll();

        assertEquals(3, allContactEntities.size());
        assertTrue(allContactEntities.contains(contactEntity1));
        assertTrue(allContactEntities.contains(contactEntity2));
        assertTrue(allContactEntities.contains(contactEntity3));
    }

}
