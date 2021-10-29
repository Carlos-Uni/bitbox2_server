package com.bitbox.bitboxserver.service;

import com.bitbox.bitboxserver.assembler.ItemAssembler;
import com.bitbox.bitboxserver.assembler.UserAssembler;
import com.bitbox.bitboxserver.dao.UserDAO;
import com.bitbox.bitboxserver.dto.ItemDTO;
import com.bitbox.bitboxserver.dto.UserDTO;
import com.bitbox.bitboxserver.model.Item;
import com.bitbox.bitboxserver.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserService implements IUserService{

    @Autowired
    UserDAO userDAO;

    private UserAssembler userAssembler = new UserAssembler();
    private ItemAssembler itemAssembler = new ItemAssembler();

    public List<UserDTO> findAllUsers(){
        List<UserDTO> userDTO = new ArrayList<>();
        for (User user : userDAO.findAll()) {
            userDTO.add(userAssembler.pojo2dto(user));
        }
        return userDTO;
    }


    public UserDTO findByUserCode(Long code) {
        User user = userDAO.findByUserCode(code);
        if (user != null) {
            return userAssembler.pojo2dto(user);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("The user '%s' does not exist", code));
        }
    }


    public void createUser(UserDTO userDTO) {
        if (userDTO == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The user to save is missing.");
        }
        userDAO.save(userAssembler.dto2pojo(userDTO));
    }


    public void deleteUser(Long code) {
        User user = userDAO.findByUserCode(code);
        if (user != null) {
            userDAO.delete(userDAO.findByUserCode(code));
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("The user '%s' does not exist", code));
        }
    }

    @Override
    public ResponseEntity<UserDTO> updateUser(Long code, UserDTO userDTO) {
        User user = userDAO.findByUserCode(code);
        Set<Item> items = new HashSet<>();

        user.setUserCode(userDTO.getUserCode());
        user.setUserName(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        for (ItemDTO itemDTO : userDTO.getItems()) {
            items.add(itemAssembler.dto2pojo(itemDTO));
        }
        user.setItems(items);

        userDAO.save(user);
        return ResponseEntity.ok().body(userAssembler.pojo2dto(user));
    }

}