package app.entities;

import java.time.LocalDateTime;

<<<<<<< HEAD
=======
import jakarta.persistence.*;
>>>>>>> 9cb2cd39efa980e5fcf040dd930a3fec3b7b176f
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.Nullable;
<<<<<<< HEAD
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
=======
>>>>>>> 9cb2cd39efa980e5fcf040dd930a3fec3b7b176f
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class StockArchive extends BaseEntity {

	
	private static final long serialVersionUID = 1L;
	@Id
	@UuidGenerator
	private String id;

	@Id
	@UuidGenerator
	private String id;

	@OneToOne
	private StockItem stockItem;
	
	@Builder.Default
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private LocalDateTime archivedAt = LocalDateTime.now();
	
	@Nullable
	private String reason;
	
	//@JsonIgnoreProperties
    //@OneToMany
	//private User user;
}
