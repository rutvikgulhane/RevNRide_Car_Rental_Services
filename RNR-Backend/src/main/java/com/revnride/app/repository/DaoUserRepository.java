package com.revnride.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revnride.app.entities.DaoUser;
import com.revnride.app.model.DAOUser;


@Repository
public interface DaoUserRepository extends JpaRepository<DaoUser, Long> {
	DaoUser findByUsername(String username);

}