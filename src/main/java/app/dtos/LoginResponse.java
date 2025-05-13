package app.dtos;

import app.entities.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {
	
	private User user;
	private String jwt;
	private String message;
	
	
}
