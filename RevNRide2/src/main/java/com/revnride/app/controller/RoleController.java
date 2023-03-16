package com.revnride.app.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revnride.app.dto.request.RoleRequest;
import com.revnride.app.dto.response.RoleResponse;
import com.revnride.app.mapper.impl.RoleMapper;
import com.revnride.app.service.RoleService;

@RestController
@RequestMapping(value="/role")
public class RoleController {

	// Logegr user to log on server
	private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

	// RoleService operation on database table roles
	private final RoleService roleServiceImpl;
	
	// RoleMapper to convert Dtos
	private final RoleMapper roleMapper;
	
	@Autowired
	public RoleController(RoleService roleServiceImpl, RoleMapper roleMapper) {
		this.roleServiceImpl = roleServiceImpl;
		this.roleMapper = roleMapper;
	}
	
	// 'user' / 'admin'
	@PostMapping("/add-role")
	public ResponseEntity<RoleResponse> addRole(@Valid @RequestBody RoleRequest roleRequest) {
		logger.info("-----added role successfully------");
		RoleResponse roleResponse = roleMapper.toDto(roleServiceImpl.addRole(roleRequest));
		return new ResponseEntity<>(roleResponse, HttpStatus.OK);
	}
	
	
}
