package com.revnride.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revnride.app.entity.Role;
import com.revnride.app.entity.Roles;

 

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    
    
    Optional<Role> findByName(Roles name);

     
    Optional<Role> findById(Integer id);
}
