package com.mongodb.scportal.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Address {

    private String city;
    private String state;
    private String nearestMajorCity;
    private double[] location;

}
