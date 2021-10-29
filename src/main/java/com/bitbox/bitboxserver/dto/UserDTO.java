package com.bitbox.bitboxserver.dto;

import com.bitbox.bitboxserver.globaldata.UserRoleEnum;
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
    private Long userCode;
    private String userName;
    private String password;
    private UserRoleEnum role;
    private Set<ItemDTO> items;

    public void addItem(ItemDTO itemDTO){
        if (items == null) {
            items = new HashSet<>();
        }
        itemDTO.setCreator(this);
        items.add(itemDTO);
    }
}