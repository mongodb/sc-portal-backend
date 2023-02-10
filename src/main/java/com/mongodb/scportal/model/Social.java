package com.mongodb.scportal.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

enum Network {LINKED_IN, FACEBOOK, TWITTER, DISCORD, TIK_TOK, SNAPCHAT};

@Getter @Setter @NoArgsConstructor
public class Social {


    private Network type;
    private String url;


}
