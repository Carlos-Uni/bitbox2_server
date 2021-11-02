package com.bitbox.bitboxserver.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class JwtResponse implements Serializable {
    private String jwttoken;
    private String username;
    private String type = "Bearer";


    public JwtResponse(String jwttoken, String username){
        this.jwttoken = jwttoken;
        this.username = username;
    }
}
