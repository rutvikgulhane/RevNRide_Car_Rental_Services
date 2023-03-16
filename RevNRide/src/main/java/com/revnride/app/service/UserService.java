package com.revnride.app.service;

import com.revnride.app.dto.response.UserResponse;
import com.revnride.app.exception.WrongDataException;

public interface UserService {
	
	/**
     * Find user on id.
     * param id is user.
     * return user data
     * throws WrongDataException when id is wrong
     */
	UserResponse findById(Long id) throws WrongDataException;
}
