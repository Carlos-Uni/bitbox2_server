package com.bitbox.bitboxserver.service;

import com.bitbox.bitboxserver.assembler.UserAssembler;
import com.bitbox.bitboxserver.dao.UserDAO;
import com.bitbox.bitboxserver.dto.UserDTO;
import com.bitbox.bitboxserver.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    UserDAO userDAO;

    private UserAssembler userAssembler = new UserAssembler();

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        User user = userDAO.findByUsername(name);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + name);
        }

        return new org.springframework.security.core.userdetails.User(user.getUserName()
                , user.getPassword(), new ArrayList<>());

        /*for (com.bitbox.bitboxserver.model.User user : userDAO.findAll()) {
            if (user.getUserName().equals(s)) {
                return new org.springframework.security.core.userdetails.User(user.getUserName()
                        , user.getPassword(), new ArrayList<>());
            }
        }

        */
    }

    public void save(UserDTO userDTO) {
        User user = userAssembler.dto2pojo(userDTO);
        String salt = BCrypt.gensalt(12);
        user.setPassword(BCrypt.hashpw(userDTO.getPassword(), salt));
        userDAO.save(user);
    }

}
