package com.bitbox.dao;

import com.bitbox.dto.UserDTO;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface UserDAO extends CrudRepository<UserDTO, Long> {
    public UserDTO findByUserCode(int code);
}
