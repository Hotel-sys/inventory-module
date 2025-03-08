package app.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
public class StockArchive extends BaseEntity {

	
	private static final long serialVersionUID = 1L;

	@OneToOne
	private StockItem stockItem;
	
	@Builder.Default
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private LocalDateTime archivedAt = LocalDateTime.now();
	
	@Nullable
	private String reason;
	
//	@OneToMany
//	private User user;
}
