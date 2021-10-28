package com.bitbox.bitboxserver.controller;

import com.bitbox.bitboxserver.dto.UserDTO;
import com.bitbox.bitboxserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user/userList")
    public List<UserDTO> getUser(){
        return userService.findAllUsers();
    }

    @GetMapping("/user/search/{code}")
    public UserDTO getUserByUserCode(@PathVariable(value = "code") int code){
        return userService.findByUserCode(code);
    }

    @PostMapping(value = "/user/create", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDTO userDTO){
        userService.createUser(userDTO);
    }

    @PutMapping("/user/update/{code}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable(value = "code") int code,
                                              @RequestBody UserDTO userDTO) {
        return userService.updateUser(code, userDTO);
    }

    @DeleteMapping("/user/delete/{code}")
    public void deleteUser(@PathVariable(value = "code") int code) {
        userService.deleteUser(code);
    }
}
