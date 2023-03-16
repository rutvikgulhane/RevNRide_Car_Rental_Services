package com.revnride.app.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.revnride.app.entity.User;

 


@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    /**userServiceImpl*/
    private final UserServiceImpl userServiceImpl;

    @Autowired
    /**Constructor*/
    public UserDetailsServiceImpl(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }


    @Override
    @Transactional
    /**Method to loadUsername*/
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userServiceImpl.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not exsit"));
        return UserDetailsimpl.build(user);
    }
}
