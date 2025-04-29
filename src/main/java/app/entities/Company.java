package app.entities;

import java.io.Serial;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.UuidGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.annotation.Nullable;

//import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.web.bind.annotation.CrossOrigin;

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
	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@UuidGenerator
	private String id;

	@NotBlank(message="Company's name is required!")
	private String name;

//	@NotBlank(message="Company's address is required!")
	@Nullable()
	private String address;

//	@NotBlank(message="Company's contact_info is required!")
	@Nullable()
	private String contactInfo;

//	@NotBlank(message="Company's phone is required!")
	@Nullable()
	private String phone;

	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email no formato algumacoisa@algumacoisa.algumacoisa.")
	private String email;

//	@NotBlank(message="Company's industry is required!")
	@Nullable()
	private String industry;

	@NotBlank(message="Company's registration_number is required!")
	private String registrationNumber;

/*
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Nullable()
	private LocalDate establishedDate;
*/

    @Nullable
	private String website;

	@Nullable
	private String notes;

	@JsonIgnoreProperties("company")
	@OneToMany(mappedBy = "company")
	private List<User> users;

//	@OneToMany(mappedBy = "stockItem")
//	private List<StockItem> stockItems;

}
