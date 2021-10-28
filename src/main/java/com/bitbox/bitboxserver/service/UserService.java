package com.bitbox.bitboxserver.service;

import com.bitbox.bitboxserver.assembler.ItemAssembler;
import com.bitbox.bitboxserver.assembler.UserAssembler;
import com.bitbox.bitboxserver.dao.ItemDAO;
import com.bitbox.bitboxserver.dao.UserDAO;
import com.bitbox.bitboxserver.dto.ItemDTO;
import com.bitbox.bitboxserver.dto.UserDTO;
import com.bitbox.bitboxserver.model.Item;
import com.bitbox.bitboxserver.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService implements IUserService{

    @Autowired
    UserDAO userDAO;

    @Autowired
    ItemDAO itemDAO;

    private UserAssembler userAssembler = new UserAssembler();
    private ItemAssembler itemAssembler = new ItemAssembler();

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

    @Override
    public ResponseEntity<UserDTO> updateUser(int code, UserDTO userDTO) {
        User user = userDAO.findByUserCode(code);
        Set<Item> items = new HashSet<>();

        user.setUserCode(userDTO.getUserCode());
        user.setUserName(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());
        user.setName(userDTO.getName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setRole(userDTO.getRole());
        for (ItemDTO itemDTO : userDTO.getItems()) {
            items.add(itemAssembler.dto2pojo(itemDTO));
        }
        user.setItems(items);

        userDAO.save(user);
        return ResponseEntity.ok().body(userAssembler.pojo2dto(user));
    }

}
