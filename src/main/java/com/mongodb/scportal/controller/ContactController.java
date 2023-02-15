package com.mongodb.scportal.controller;

import com.mongodb.scportal.model.Contact;
import com.mongodb.scportal.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping(value="contact", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class ContactController {


    @Autowired
    private ContactService service;

    @GetMapping
    public List<Contact> getAll(){
        return service.getAll();
    }

    @GetMapping(value="{id}")
    public Contact getById(@PathVariable("id") String id){
        Optional<Contact> contact = service.findContact(id);
        return contact.orElse(null);
    }


    @PostMapping
    public Contact createContact(@RequestBody Contact contact) {
        return service.createContact(contact);
    }







}