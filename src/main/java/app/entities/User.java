package app.entities;

import org.hibernate.annotations.UuidGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Collection;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name="user_tb")
public class User extends BaseEntity implements UserDetails {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@UuidGenerator
	private String id;

	@NotBlank(message="User's name is required!")
	private String name;	
	
	@Builder.Default
	private String role = "Admin";
	
	@NotBlank(message="User's email is required!")
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email no formato algumacoisa@algumacoisa.algumacoisa.")
	private String email;

	@NotBlank(message="User's password is required!")
	private String password;

	@JsonIgnoreProperties("users")
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;

	@JsonIgnoreProperties("users")
	@ManyToOne
	@JoinColumn(name = "company_id")
	@Cascade(value = org.hibernate.annotations.CascadeType.DETACH)
	private Company company;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return null;
	}

	@Override
	public String getUsername() {
		
		return null;
	}
}
