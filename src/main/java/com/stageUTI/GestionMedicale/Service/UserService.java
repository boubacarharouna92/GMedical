package com.stageUTI.GestionMedicale.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.stageUTI.GestionMedicale.Beans.Role;
import com.stageUTI.GestionMedicale.Beans.User;



@Service
@Transactional
public class UserService {

	@Autowired
	private com.stageUTI.GestionMedicale.Repository.UserRepository userRepository;

	public void createSecretaire(com.stageUTI.GestionMedicale.Beans.User user) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		com.stageUTI.GestionMedicale.Beans.Role userRole = new com.stageUTI.GestionMedicale.Beans.Role("SECRETAIRE");
		List<com.stageUTI.GestionMedicale.Beans.Role> roles = new ArrayList<>();
		roles.add(userRole);
		user.setRoles(roles);
		userRepository.save(user);

	}

	public void createMedecin(User user) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		Role userRole = new Role("MEDECIN");
		List<Role> roles = new ArrayList<>();
		roles.add(userRole);
		user.setRoles(roles);
		userRepository.save(user);

	}
	
	public void createAdmin(User user) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		Role userRole = new Role("ADMIN");
		List<Role> roles = new ArrayList<>();
		roles.add(userRole);
		user.setRoles(roles);
		userRepository.save(user);

	}
	
	
	
	

	public User findOne(String email) {
		Optional<User> optUser = userRepository.findById(email); // returns java8 optional
		if (optUser.isPresent()) {
			return optUser.get();
		} else {

			return null;
		}
	}

	public boolean isUserPresent(String email) {

		User user = findOne(email);
		if (user != null) {
			return true;
		} else {
			return false;
		}
		
		//importante partie
		/*
		 * Optional<User> optUser = userRepository.findById(email); // returns java8
		 * optional if (optUser.isPresent()) { User u = optUser.get(); if (u!=null)
		 * return true; } return false;
		 */
	}

	public Object findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	public List<User> findByName(String name) {
		// TODO Auto-generated method stub
		return userRepository.findByNameLike("%"+name+"%");
	}

}
