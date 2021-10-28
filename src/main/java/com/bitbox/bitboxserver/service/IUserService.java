package com.bitbox.bitboxserver.service;

import com.bitbox.bitboxserver.dto.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService {
    public List<UserDTO> findAllUsers();
    public UserDTO findByUserCode(int code);
    public void createUser(UserDTO userDTO);
    public void deleteUser(int code);
    public ResponseEntity<UserDTO> updateUser(int code, UserDTO userDTO);
}
