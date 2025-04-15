package app.entities;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.Nullable;
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
