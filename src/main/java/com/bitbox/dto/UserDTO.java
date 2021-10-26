package com.bitbox.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long idUser;
    private Integer userCode;
    private String userName;
    private String password;
    private String name;
    private String lastName;
    private String email;
    private String role;
    private Set<ItemDTO> items;

    public void addItemToUser(ItemDTO itemDTO){
        if(items==null)items = new HashSet<>();
        itemDTO.setCreator(this);
        items.add(itemDTO);
    }

}