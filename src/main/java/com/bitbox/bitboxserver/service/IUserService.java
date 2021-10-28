package com.bitbox.bitboxserver.service;

import com.bitbox.bitboxserver.dto.UserDTO;

import java.util.List;

public interface IUserService {
    public List<UserDTO> findAllUsers();
    public UserDTO findByUserCode(Long code);
    public void createUser(UserDTO userDTO);
    public void deleteUser(Long code);
}
