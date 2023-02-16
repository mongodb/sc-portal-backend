package com.mongodb.scportal.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Document("sizing")
public class Sizing {

    @Id
    private String id;

    private String title;
    private String description;

    private Workload workload;

    private List<DataSize> dataSize;




}
