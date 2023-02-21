package com.mongodb.scportal.repository;

import com.mongodb.scportal.model.Contact;
import com.mongodb.scportal.model.Workload;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends MongoRepository<Contact, String> {


    @Aggregation(pipeline = {"{'$match': {}},{'$sort': {'lastUpdate':-1}},{'$limit': 50}]"})
    List<Contact> getRecent();


    @Aggregation(pipeline = {"{'$search': {'index':'default','text': {'path': ['fullName','email','account.name'], 'query': '?0'}}}"})
    List<Contact> searchContacts(String name);


}
