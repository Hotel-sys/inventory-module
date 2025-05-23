package app.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.UuidGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Supplier extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@UuidGenerator
	private String id;

	private String name;

	private String address;

	private String phone;

	private String email;

	private String notes;

	private String paymentTerms;

	private LocalDateTime deliverySchedule;

    @JsonIgnoreProperties("company")
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company  company;

}
