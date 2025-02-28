package app.entities;

import java.time.LocalDateTime;
import java.util.List;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class Company extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	private String name;	
	
	@NotNull
	private String address;
	
	@NotNull
	private String contact_info;
	
	@NotNull
	private String phone;
	
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email no formato algumacoisa@algumacoisa.algumacoisa.")
	private String email;
	
	@Nullable
	private String industry;
	
	@NotBlank
	private String registration_number;	
	
	@NotBlank
	private LocalDateTime established_date;
	
	@Nullable
	private String website;
	
	@Nullable
	private String notes;	
	
	@OneToMany(mappedBy = "company")
	private List<User> user;
	
}
