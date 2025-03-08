package app.entities;

import java.util.List;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
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
public class Category extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@NotBlank
	private String name;
	
	@Nullable
	private String description;
	
	@OneToMany(mappedBy = "category")
	private List<StockItem> stockItems;
}
