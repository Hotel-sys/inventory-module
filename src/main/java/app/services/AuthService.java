package app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dtos.LoginRequest;
import app.entities.User;
import app.repositories.UserRepository;

@Service
public class AuthService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void login(LoginRequest loginRequest) {
		Optional<User> user = userRepository.findByEmail(loginRequest.getEmail());
		if(user.isPresent()) {
			if(user.get)
		}
	}
	
	public void logout() {
			
	}
}
