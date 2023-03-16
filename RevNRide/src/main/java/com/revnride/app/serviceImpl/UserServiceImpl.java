package com.revnride.app.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revnride.app.dto.response.UserResponse;
import com.revnride.app.entity.User;
import com.revnride.app.exception.WrongDataException;
import com.revnride.app.mapperImpl.UserMapper;
import com.revnride.app.repository.UserRepository;
import com.revnride.app.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class UserServiceImpl implements UserService{

	
	
	@Autowired
	private UserRepository userRepository;
	
	 @Override
	    public UserResponse findById(Long id) throws WrongDataException {
	        if (!userRepository.existsById(id)) {
	            log.error("---- USER NOT EXIST ----");
	            throw new WrongDataException("User not Exist");
	        } else {
	            log.info("---- USER ON ID "+id+" ----");
	            User user = userRepository.findById(id).orElse(null); 
				/*
				 
				 * userResponse = new UserResponse(); userResponse.setId(id);
				 * userResponse.setEmail(user.getEmail());
				 * userResponse.setUsername(user.getUsername());
				 * userResponse.setRole(user.getRole());
				 */
	            return new UserMapper().toDto(user);
	        }
	    }

}
