package app.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
public class StockItem extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@NotBlank
	private String name;
	
	@NotBlank
	private String description;
	
	private int quantity;
	
	private String unit;
	
	private boolean archived;
	
	/*
	@JsonIgnoreProperties
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	*/
	
	@JsonIgnoreProperties
	@ManyToMany
    @JoinTable(
        name = "stockitem_category", 
        joinColumns = @JoinColumn(name = "stock_item_id"), 
        inverseJoinColumns = @JoinColumn(name = "category_id") 
    )
	private List<Category> categories;
	
	@JsonIgnoreProperties
	@ManyToOne
	@JoinColumn(name = "supplier_id")
	private Supplier supplier;
	
	@JsonIgnoreProperties
	@OneToOne(mappedBy = "stockItem")
	private StockArchive stockArchive;
	
	@JsonIgnoreProperties
	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;
	
	@JsonIgnoreProperties
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;
	
}
