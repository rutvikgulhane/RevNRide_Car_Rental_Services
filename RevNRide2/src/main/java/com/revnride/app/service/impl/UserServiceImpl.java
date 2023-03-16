package com.revnride.app.service.impl;

//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.revnride.app.dto.request.UserRequest;
import com.revnride.app.dto.response.ReservationResponse;
import com.revnride.app.dto.response.UserResponse;
import com.revnride.app.entity.Role;
import com.revnride.app.entity.Roles;
import com.revnride.app.entity.User;
import com.revnride.app.exception.WrongDataException;
import com.revnride.app.mapper.Mapper;
import com.revnride.app.mapper.impl.ReservationMapper;
import com.revnride.app.repository.ReservationRepository;
import com.revnride.app.repository.RoleRepository;
import com.revnride.app.repository.UserRepository;
import com.revnride.app.service.EmailSending;
import com.revnride.app.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final ReservationRepository reservationRepository;
	private final RoleRepository roleRepository;
	private final PasswordEncoder encoder;
	private final ReservationMapper reservationMapper;
	private final EmailSending emailSending;
	private final Mapper<User, UserResponse, UserRequest> userMapper;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, ReservationRepository reservationRepository,
			RoleRepository roleRepository, PasswordEncoder encoder,
			EmailSending emailSending,
			ReservationMapper reservationMapper, Mapper<User, UserResponse, UserRequest> userMapper) {
		this.userRepository = userRepository;
		this.reservationRepository = reservationRepository;
		this.roleRepository = roleRepository;
		this.encoder = encoder;
		this.emailSending = emailSending;
		this.reservationMapper = reservationMapper;
		this.userMapper = userMapper;
	}

	@Override
	public Optional<User> findByUsername(String username) {
		log.info("---- FIND USER ON USERNAME " + username + " ----");
		return userRepository.findByUsername(username);
	}

	@Override
	public List<ReservationResponse> getReservationUser(Long id) throws WrongDataException {
		if (!reservationRepository.existsByIdrent(id)) {
			log.error("---- NOT EXIST RESERVATION ----");
			throw new WrongDataException("Reservation not exist!!!");
		} else {
			if (!userRepository.existsById(id)) {
				log.error("---- NOT EXIST USER ----");
				throw new WrongDataException("User not Exist");
			} else {
				log.info("---- GET USER RESERVATION ON ID " + id + " ----");
				List<ReservationResponse> reservations = userRepository.getReservationUser(id).stream()
						.map(reservation -> reservationMapper.toDto(reservation)).collect(Collectors.toList());
				return reservations;
			}
		}
	}


	@Override
	public void deleteUser(Long id) throws WrongDataException {
		if (!userRepository.existsById(id)) {
			log.error("---- NOT EXIST USER " + id + " ----");
			throw new WrongDataException("User not Exist");
		} else {
			log.info("---- DELETE USER ID " + id + "----");
			userRepository.deleteById(id);
		}
	}


	@Override
	public void update(User user) {
		log.info("---- USER UPDATE ----");
		userRepository.save(user);
	}


	@Override
	public void update(UserRequest userRequest, Long id) throws WrongDataException {
		if (!userRepository.existsById(id)) {
			log.error("---- USER NOT EXIST ----");
			throw new WrongDataException("User not Exist");
		} else {
			User user = userRepository.findById(id).get();
			user = userMapper.update(user, userRequest);
			List<Role> roles = new LinkedList<>();
			if (userRequest.getRole().isEmpty()) {
				roles.add(roleRepository.findByName(Roles.ROLE_USER).get());
			}
			for (String rol : userRequest.getRole()) {
				if (rol.equals("user")) {
					roles.add(roleRepository.findByName(Roles.ROLE_USER).get());
				} else if (rol.equals("admin")) {
					roles.add(roleRepository.findByName(Roles.ROLE_ADMIN).get());
				}
			}
			user.setRoles(roles);
			userRepository.save(user);
			log.info("---- USER UPDATE ----");
		}
	}


	@Override
	public UserResponse findByEmail(String email) {
		log.info("---- FIND USER ON EMAIL " + email + " ----");
		return userMapper.toDto(userRepository.findByEmail(email).get());
	}


	@Override
	public UserResponse findById(Long id) throws WrongDataException {
		if (!userRepository.existsById(id)) {
			log.error("---- USER NOT EXIST ----");
			throw new WrongDataException("User not Exist");
		} else {
			log.info("---- USER ON ID " + id + " ----");
			User user = userRepository.findById(id).get();
			System.out.println("in findById of UserServiceImpl---> " + user);
			return userMapper.toDto(user);
		}
	}


	@Override
	public void save(UserRequest userRequest) throws WrongDataException {
		if (userRepository.existsByUsername(userRequest.getUsername())) {
			log.error("---- USER EXIST ----");
			throw new WrongDataException("User Exist");
		} else {
			log.info("-------" + userRequest + "------");
			List<Role> roles = new LinkedList<>();
			if (userRequest.getRole() == null ) {
				roles.add(roleRepository.findByName(Roles.ROLE_USER).get());
				log.info("------------->>>" + roles.toString());
			} else
				for (String rol : userRequest.getRole()) {
					if (rol.equals("user")) {
						roles.add(roleRepository.findByName(Roles.ROLE_USER).get());
					} else if (rol.equals("admin")) {
						roles.add(roleRepository.findByName(Roles.ROLE_ADMIN).get());
					}
				}
			User user = userMapper.toEntity(userRequest);
			user.setRoles(roles);
			userRepository.save(user);
            emailSending.sendEmail(user.getEmail(), "Thankyou for registering on Revv-N-Ride, your Email->"
			+user.getEmail() +" and password->"+user.getPassword(), "Registered on Revv-N-Ride successfully");
			log.info("---- SAVE USER ----");
		}
	}


	@Override
	public List<UserResponse> findAll() {
		log.info("---- FIND ALL USER ----");
		return userRepository.findAll().stream().map(user -> userMapper.toDto(user)).collect(Collectors.toList());
	}


	@Override
	public UserResponse findByReservationsIdRent(Long id) {
		log.info("---- FIND RESERVATION ON ID USER " + id + " ----");
		return userMapper.toDto(userRepository.findByReservations_Idrent(id));
	}

}
