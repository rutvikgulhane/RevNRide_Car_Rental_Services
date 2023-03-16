package com.revnride.app.mapper.impl;

import java.util.stream.Collectors;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.revnride.app.dto.request.UserRequest;
import com.revnride.app.dto.response.RoleResponse;
import com.revnride.app.dto.response.UserResponse;
import com.revnride.app.entity.User;
import com.revnride.app.mapper.Mapper;


@Component
public class UserMapper implements Mapper<User, UserResponse, UserRequest> {

   
    @Override
    public UserResponse toDto(User user) {
        return new UserResponse().builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .roles(user.getRoles().parallelStream().map(role -> new RoleResponse().builder().id(role.getId()).name(role.getName().toString()).build()).collect(Collectors.toList()))
                .build();

    }

 
    @Override
    public User toEntity(UserRequest userRequest) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return new User().builder()
                .username(userRequest.getUsername())
                .email(userRequest.getEmail())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .build();
    }

 
    @Override
    public User update(User user, UserRequest userRequest) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setUsername(userRequest.getUsername());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.setEmail(userRequest.getEmail());
        return user;
    }
}
