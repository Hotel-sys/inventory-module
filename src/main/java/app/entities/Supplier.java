package app.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
public class Supplier extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String name;
		
	private String address;
	
	private String phone;
	
	private String email;
	
	private String notes;
	
	private String paymentTerms;
	
	private LocalDateTime deliverySchedule;
	
}
