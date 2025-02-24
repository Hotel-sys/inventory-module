package app.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
public class Client extends BaseEntity {

	@Column(nullable = false)
	@NotBlank
	private String name;

	@Column(nullable = false, updatable = false)
	@Builder.Default
	private boolean firstPurchase = false;
	
	private int age;
	
	
}
