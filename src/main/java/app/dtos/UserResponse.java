package app.dtos;

import app.entities.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
	private String message;
	private User user;
}
