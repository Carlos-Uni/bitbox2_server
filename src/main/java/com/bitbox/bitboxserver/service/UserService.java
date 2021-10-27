package com.bitbox.bitboxserver.service;

import com.bitbox.bitboxserver.assembler.UserAssembler;
import com.bitbox.bitboxserver.dao.UserDAO;
import com.bitbox.bitboxserver.dto.ItemDTO;
import com.bitbox.bitboxserver.dto.UserDTO;
import com.bitbox.bitboxserver.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    UserDAO userDAO;

    private UserAssembler userAssembler = new UserAssembler();

    @Override
    public List<UserDTO> findAllUsers(){
        List<UserDTO> userDTO = new ArrayList<>();
        for (User user : userDAO.findAll()) {
            userDTO.add(userAssembler.pojo2dto(user));
        }
        return userDTO;
    }

    @Override
    public UserDTO findByUserCode(int code) {
        return userAssembler.pojo2dto(userDAO.findByUserCode(code));
    }

    @Override
    public void createUser(UserDTO userDTO) {
        userDAO.save(userAssembler.dto2pojo(userDTO));
    }

    @Override
    public void deleteUser(int code) {
        User user = userDAO.findByUserCode(code);
        userDAO.delete(user);
    }

}
