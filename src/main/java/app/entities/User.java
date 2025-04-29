package app.entities;

import org.hibernate.annotations.UuidGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

<<<<<<< HEAD
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
=======
import jakarta.persistence.*;
>>>>>>> 9cb2cd39efa980e5fcf040dd930a3fec3b7b176f
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name="user_tb")
public class User extends BaseEntity{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@UuidGenerator
	private String id;

	@NotBlank(message="User's name is required!")
	private String name;

	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email no formato algumacoisa@algumacoisa.algumacoisa.")
	private String email;

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
}
