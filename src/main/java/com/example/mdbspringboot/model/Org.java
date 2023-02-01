package com.example.mdbspringboot.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document("org")
@Getter @Setter @NoArgsConstructor @ToString @AllArgsConstructor
public class Org {
    @Id
    private String id;


}
