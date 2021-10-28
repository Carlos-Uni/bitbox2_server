package com.bitbox.bitboxserver.dao;

import com.bitbox.bitboxserver.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends CrudRepository<User, Long> {
    public User findByUserCode(Long code);
}
