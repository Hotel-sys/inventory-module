package app.entities;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class Example extends BaseEntity {



	private static final long serialVersionUID = 1L;

	@Id
	@UuidGenerator
	private String id;
<<<<<<< HEAD
	
=======

>>>>>>> 9cb2cd39efa980e5fcf040dd930a3fec3b7b176f
	@NotBlank
	private String ping;	
	
}
