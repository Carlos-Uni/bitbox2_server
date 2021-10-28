package com.bitbox.bitboxserver.assembler;

import com.bitbox.bitboxserver.dto.UserDTO;
import com.bitbox.bitboxserver.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserAssembler {

    private final ModelMapper modelMapper = new ModelMapper();

    public UserDTO pojo2dto(User pojo) {

        return modelMapper.map(pojo, UserDTO.class);
    }

    public User dto2pojo(UserDTO dto) {

        return modelMapper.map(dto, User.class);
    }
}
