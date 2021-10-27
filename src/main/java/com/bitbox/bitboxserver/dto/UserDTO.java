package com.bitbox.bitboxserver.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {

    private Long idUser;
    private Integer userCode;
    private String userName;
    private String password;
    private String name;
    private String lastName;
    private String email;
    private String role;
    private Set<ItemDTO> items;
}