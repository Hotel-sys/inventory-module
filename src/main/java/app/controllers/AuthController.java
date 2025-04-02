package app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.dtos.LoginRequest;
import app.services.AuthService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

	@Autowired
	private AuthService authService;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
		String result = authService.login(loginRequest);
		return new ResponseEntity<>(result, HttpStatus.OK);		
	}
	
	@GetMapping("/logout")
	public ResponseEntity<Void> logout() {
		if(authService.logout()) {
			return ResponseEntity.noContent().build();
		}
		
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
}
