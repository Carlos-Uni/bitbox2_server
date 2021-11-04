package com.bitbox.bitboxserver.controller;

import com.bitbox.bitboxserver.configuration.JwtTokenUtil;
import com.bitbox.bitboxserver.dto.UserDTO;
import com.bitbox.bitboxserver.model.JwtRequest;
import com.bitbox.bitboxserver.model.JwtResponse;
import com.bitbox.bitboxserver.service.JwtUserDetailsService;
import com.bitbox.bitboxserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class JwtAuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    JwtUserDetailsService userDetailsService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
            throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDTO userDTO) throws Exception {
        try {
            userDetailsService.save(userDTO);
        } catch (RuntimeException e) {
            throw new Exception("The user (" + userDTO.getUserName() + ") already exist");
        }
        return ResponseEntity.ok(userDTO);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("user disabled", e);
        } catch (BadCredentialsException e) {
            throw new Exception("invalid credentials", e);
        }
    }
}
