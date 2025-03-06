package app.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

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

	@NotBlank(message="Company's name is required!")
	private String name;	
	
	@NotBlank(message="Company's address is required!")
	private String address;
	
	@NotBlank(message="Company's contact_info is required!")
	private String contact_info;
	
	@NotBlank(message="Company's phone is required!")
	private String phone;
	
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email no formato algumacoisa@algumacoisa.algumacoisa.")
	private String email;
	
	@NotBlank(message="Company's industry is required!")
	private String industry;
	
	@NotBlank(message="Company's registration_number is required!")
	private String registration_number;	
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private LocalDate established_date;
	
	@Nullable
	private String website;
	
	@Nullable
	private String notes;	
	
	@OneToMany(mappedBy = "company")
	private List<User> user;
	
}
