package app.dtos;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import app.entities.Company;
import app.entities.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequest {
	private String email;
	private String senha;
}
