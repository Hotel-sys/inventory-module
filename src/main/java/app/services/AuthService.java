package app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import app.config.JwtServiceGenerator;
import app.dtos.LoginRequest;
import app.dtos.LoginResponse;
import app.entities.User;
import app.exceptions.UserCredentialsIncorrectException;
import app.exceptions.UserNotFoundException;
import app.repositories.UserRepository;

@Service
public class AuthService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;
	
	@Autowired
	private JwtServiceGenerator jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	public String gerarToken(LoginRequest loginRequest) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						loginRequest.getEmail(),
						loginRequest.getSenha()
						)
				);
		User user = userRepository.findByEmail(loginRequest.getEmail()).get();
		String jwtToken = jwtService.generateToken(user);
		System.out.println(jwtToken);
		return jwtToken;
	}
	
	public LoginResponse login(LoginRequest loginRequest) {
	    Optional<User> user = userRepository.findByEmail(loginRequest.getEmail());

	    if (user.isPresent()) {
	        boolean correctPassword = bcryptEncoder.matches(loginRequest.getSenha(), user.get().getPassword());
	        if (correctPassword) {
	        	String jwt = this.gerarToken(loginRequest);
	            return LoginResponse.builder()
	            		.jwt(jwt)
	            		.user(user.get())
	            		.message(jwt)
	            		.build();
	        }
	        throw new UserCredentialsIncorrectException("Email/senha incompatíveis");
	    }
	    throw new UserNotFoundException("Usuário nao existe!");
	}
	
	public boolean logout() {
			return true;
	}
}
