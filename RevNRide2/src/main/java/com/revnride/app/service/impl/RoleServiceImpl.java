package com.revnride.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revnride.app.dto.request.RoleRequest;
import com.revnride.app.dto.response.RoleResponse;
import com.revnride.app.entity.Role;
import com.revnride.app.entity.Roles;
import com.revnride.app.mapper.Mapper;
import com.revnride.app.repository.RoleRepository;
import com.revnride.app.service.RoleService;

import lombok.extern.slf4j.Slf4j;

 

@Service
@Slf4j
@Transactional
public class RoleServiceImpl implements RoleService {

    /**
     * roleRepository
     */
    private final RoleRepository roleRepository;
    /**
     * role mapper
     */
    private final Mapper<Role, RoleResponse, RoleRequest> roleMapper;

    @Autowired
    /**Constructor*/
    public RoleServiceImpl(RoleRepository roleRepository, Mapper<Role, RoleResponse, RoleRequest> roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

   
    @Override
    public RoleResponse findByName(Roles name) {
        log.info("---- FIND ROLE NAME "+name+" ----");
        return roleMapper.toDto(roleRepository.findByName(name).get());
    }

     
    @Override
    public RoleResponse findById(int id) {
        log.info("---- FIND ROLE ID "+id+" ----");
        return roleMapper.toDto(roleRepository.findById(id).get());
    }

   
    @Override
    public List<RoleResponse> findAll() {
        log.info("---- FIND ALL ROLE ----");
        return roleRepository.findAll().stream().map(role -> roleMapper.toDto(role)).collect(Collectors.toList());
    }

	@Override
	public Role addRole(RoleRequest role) {
		log.info("------Adding a role------");
		return roleRepository.save(roleMapper.toEntity(role));
	}
}
