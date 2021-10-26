package com.bitbox.assembler;

import com.bitbox.dto.UserDTO;
import com.bitbox.model.User;
import org.modelmapper.ModelMapper;

public class UserAssembler {
    public UserDTO pojo2dto(User pojo) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(pojo, UserDTO.class);
    }

    public User dto2pojo(UserDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, User.class);
    }
}
