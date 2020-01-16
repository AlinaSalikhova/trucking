package ru.alina.trucking.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.alina.trucking.entities.User;
import ru.alina.trucking.entities.jpa.RoleRepository;
import ru.alina.trucking.exceptions.UserNotFoundException;
import ru.alina.trucking.entities.Role;
import ru.alina.trucking.entities.jpa.UserRepository;


@Service
public class UserService {
	
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	
	@Value("${blablacargo.roles.default}")
	private String defaultRole;
	
	@Value("${blablacargo.security.password.encoder}")
	private String passwordEncoder;
	
	@Autowired
	public UserService(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}
	
	public boolean isAdmin(String username) {
		List<Role> roles = roleRepository.findByUsername(username);
		Optional<Role> maybeAdmin = roles.stream()
				.filter((Role role) -> role.getAuthority().equals("ROLE_ADMIN"))
				.findAny();
		return maybeAdmin.isPresent(); 
	}
	
	public boolean isAdmin(User user) {
		return isAdmin(user.getUsername());  
	}
	
	public List<User> getAll() {
		List<User> users = userRepository.findAll(); 
		return users;
	}
	
	public User getUser(String username) {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UserNotFoundException(username));
		return user;
	}
	
	public User createUser(User input, List<String> roles) {
		String storedPassword = String.format("{%s}%s", passwordEncoder, input.getPassword());
		input.setPassword(storedPassword);
		User savedUser = userRepository.save(input);
		String rolesString;
		if (roles == null) {
			rolesString = roleRepository.save(new Role(savedUser.getUsername(), defaultRole)).getAuthority();	
		} else {
			rolesString = roles.stream()
					.map((String roleString) -> {
						Role role = roleRepository.save(new Role(savedUser.getUsername(), roleString));
						return roleString;
					})
					.collect(Collectors.joining(", "));
		}
		return savedUser;
	};
	
	public User createUser(User input) {
		return createUser(input, null);
	}
	
	public User replaceUser(User input) {
		User user = userRepository.findByUsername(input.getUsername())
				.orElseThrow(() -> new UserNotFoundException(input.getUsername()));
		return null;
	}

	public User updateUser(User input) {
		User user = userRepository.findByUsername(input.getUsername())
				.orElseThrow(() -> new UserNotFoundException(input.getUsername()));
		return null;
	}
	
	public void deleteUser(String username) {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UserNotFoundException(username));
	}
	
	public User getLoggedInUser() {
		String username = getLoggedInUsername();
		User user = getUser(username);
		return user;
	}
	
	public String getLoggedInUsername() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		} else {
			username = principal.toString();
		}
		return username;
	}
}