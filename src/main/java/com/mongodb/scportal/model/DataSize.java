package com.mongodb.scportal.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class DataSize {

    private String name;
    private long recordCount;
    private double avgRecordSize;


}
