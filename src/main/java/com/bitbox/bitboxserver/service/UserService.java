package com.bitbox.bitboxserver.service;

import com.bitbox.bitboxserver.assembler.UserAssembler;
import com.bitbox.bitboxserver.dao.UserDAO;
import com.bitbox.bitboxserver.dto.ItemDTO;
import com.bitbox.bitboxserver.dto.UserDTO;
import com.bitbox.bitboxserver.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService implements IUserService{

    @Autowired
    UserDAO userDAO;

    private UserAssembler userAssembler = new UserAssembler();

    public List<UserDTO> findAllUsers(){
        List<UserDTO> userDTO = new ArrayList<>();
        for (User user : userDAO.findAll()) {
            userDTO.add(userAssembler.pojo2dto(user));
        }
        return userDTO;
    }


    public UserDTO findByUserCode(Long code) {
        return userAssembler.pojo2dto(userDAO.findByUserCode(code));
    }


    public void createUser(UserDTO userDTO) {
        if (userDTO == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The user to save is missing.");
        }
        userDAO.save(userAssembler.dto2pojo(userDTO));
    }


    public void deleteUser(Long code) {
        if (userDAO.findByUserCode(code) != null) {
            userDAO.delete(userDAO.findByUserCode(code));
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("The user '%s' does not exist", code));
        }
    }

}
