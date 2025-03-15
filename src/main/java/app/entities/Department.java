package app.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class Department extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank(message="Department's name is required!")
	private String name;
	
	@NotBlank(message="Department's description is required!")
	private String description;	
	
	@JsonIgnoreProperties
	@OneToMany(mappedBy = "department")
	private List<User> user;
}
