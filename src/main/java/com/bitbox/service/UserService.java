package com.bitbox.service;

import com.bitbox.dao.UserDAO;
import com.bitbox.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    UserDAO userDAO;

    public List<UserDTO> findAllUsers(){
        return (List<UserDTO>)userDAO.findAll();
    }

    @Override
    public UserDTO findUser(int code) {
        return userDAO.findByUserCode(code);
    }
}
