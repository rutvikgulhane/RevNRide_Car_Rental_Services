package com.revnride.app.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.revnride.app.dto.UserDTO;
import com.revnride.app.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	
	@Autowired
	private UserRepository userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		List<SimpleGrantedAuthority> roles = null;
		
			
		com.revnride.app.entity.User user = userDao.findByEmail(email);
		if (user != null) {
			roles = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
			return new User(user.getUsername(), user.getPassword(), roles);
		}
		throw new UsernameNotFoundException("User not found with the email " + email);	}
	
	public com.revnride.app.entity.User save(UserDTO user) {
		com.revnride.app.entity.User newUser = new com.revnride.app.entity.User();
		newUser.setUsername(user.getUsername());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(user.getPassword());
//		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setRole(user.getRole());
		return userDao.save(newUser);
	}

}
