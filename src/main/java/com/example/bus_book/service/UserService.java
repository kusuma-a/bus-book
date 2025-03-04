package com.example.bus_book.service;


import com.example.bus_book.entity.User;
import com.example.bus_book.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        //List<GrantedAuthority>  authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
        user.setAuthorities(Collections.singletonList("ROLE_USER"));

        userRepository.save(user);
    }
}