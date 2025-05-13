package app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import app.dtos.LoginRequest;
import app.entities.User;
import app.repositories.UserRepository;

@Service
public class AuthService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;
	
	public String login(LoginRequest loginRequest) {
	    Optional<User> user = userRepository.findByEmail(loginRequest.getEmail());

	    if (user.isPresent()) {
	        boolean correctPassword = bcryptEncoder.matches(loginRequest.getSenha(), user.get().getPassword());
	        if (correctPassword) {
	            return "Email verified.";
	        }
	        return "Credentials failed.";
	    }
	    return "User is not present";
	}
	
	public boolean logout() {
			return true;
	}
}
