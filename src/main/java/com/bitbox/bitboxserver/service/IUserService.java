package com.bitbox.bitboxserver.service;

import com.bitbox.bitboxserver.dto.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService {
    public List<UserDTO> findAllUsers();
    public UserDTO findByUserCode(Long code);
    public UserDTO findByUserName(String name);
    public void createUser(UserDTO userDTO);
    public void deleteUser(Long code);
    public ResponseEntity<UserDTO> updateUser(Long code, UserDTO userDTO);
}
