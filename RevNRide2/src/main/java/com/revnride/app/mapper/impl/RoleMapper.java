package com.revnride.app.mapper.impl;

import org.springframework.stereotype.Component;

import com.revnride.app.dto.request.RoleRequest;
import com.revnride.app.dto.response.RoleResponse;
import com.revnride.app.entity.Role;
import com.revnride.app.entity.Roles;
import com.revnride.app.mapper.Mapper;

 
@Component
public class RoleMapper implements Mapper<Role, RoleResponse, RoleRequest> {

    
    @Override
    public RoleResponse toDto(Role role) {
        return new RoleResponse().builder()
                .id(role.getId())
                .name(role.getName().toString())
                .build();
    }

    
    @Override
    public Role toEntity(RoleRequest roleRequest) {
        return new Role().builder()
                .name(Roles.valueOf(roleRequest.getName()))
                .build();
    }

   
    @Override
    public Role update(Role role, RoleRequest roleRequest) {
         role.setName(Roles.valueOf(roleRequest.getName()));
         return role;
    }
}
