package app.entities;

import java.util.List;

<<<<<<< HEAD
import org.hibernate.annotations.UuidGenerator;

=======
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
>>>>>>> 9cb2cd39efa980e5fcf040dd930a3fec3b7b176f
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
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
public class Category extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@UuidGenerator
	private String id;

	@NotBlank
	private String name;

	@Nullable
	private String description;

	/*
	@JsonIgnoreProperties
	@OneToMany(mappedBy = "category")
	private List<StockItem> stockItems;
	*/

	@JsonIgnoreProperties("categories")
    @ManyToMany(mappedBy = "categories")
    private List<StockItem> stockItems;

}
