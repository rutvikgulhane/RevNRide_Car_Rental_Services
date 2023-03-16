package com.revnride.app.mapperImpl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.revnride.app.dto.request.UserRequest;
import com.revnride.app.dto.response.UserResponse;
import com.revnride.app.entity.User;
import com.revnride.app.mapper.Mapper;

@Component
public class UserMapper implements Mapper<User, UserResponse, UserRequest> {

	@Override
	public UserResponse toDto(User u) {
		// TODO Auto-generated method stub
		return new UserResponse().builder()
				.id(u.getId())
				.username(u.getUsername())
				.email(u.getEmail())
				.role(u.getRole())
				.build();
	}

	@Override
	public User toEntity(UserRequest z) {
		// TODO Auto-generated method stub
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return new User().builder()
				.username(z.getUsername())
				.email(z.getEmail())
				.password(passwordEncoder.encode(z.getPassword()))
				.role(z.getRole())
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
