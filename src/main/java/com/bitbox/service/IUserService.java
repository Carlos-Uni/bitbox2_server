package com.bitbox.service;

import com.bitbox.dto.UserDTO;

public interface IUserService {
    public Iterable<UserDTO> findAllUsers();
    public UserDTO findUser(int code);
}
