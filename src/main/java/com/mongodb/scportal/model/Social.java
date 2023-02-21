package com.mongodb.scportal.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

enum Network {LINKED_IN, FACEBOOK, TWITTER, DISCORD, TIK_TOK, SNAPCHAT};

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Social {


    private Network type;
    private String url;


}
