package com.mongodb.scportal.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document("contact")
@Getter @Setter @NoArgsConstructor @ToString @AllArgsConstructor
public class Contact {


    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String fullName;
    private String preferredName;

    private String role;
    private String email;

    private List<Phone> phones;

    private Address address;

    private Org account;

    private List<Social> social;

    private Date firstContacted;
    private Date lastContacted;

    private Champion champion;


}
