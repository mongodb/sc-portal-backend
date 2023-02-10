package com.mongodb.scportal.service;

import com.mongodb.scportal.model.Contact;
import com.mongodb.scportal.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {


    @Autowired
    private ContactRepository repository;

    @Autowired
    private MongoTemplate template;

    public List<Contact> getAll(){
        return repository.findAll();
    }

    public Optional<Contact> findContact(String id){
        return repository.findById(id);
    }

    public Contact createContact(Contact contact) {
        return repository.insert(contact);
    }

}
