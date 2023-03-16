package com.revnride.app.service;

import java.util.List;

import com.revnride.app.dto.request.RoleRequest;
import com.revnride.app.dto.response.RoleResponse;
import com.revnride.app.entity.Role;
import com.revnride.app.entity.Roles;

 


public interface RoleService {

	Role addRole(RoleRequest role);
	
	RoleResponse findByName(Roles name);

    RoleResponse findById(int id);

    List<RoleResponse> findAll();
}
