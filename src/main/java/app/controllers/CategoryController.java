package app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.entities.Category;
import app.interfaces.IController;
import app.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin("*")
public class CategoryController implements IController<Category> {
	
	@Autowired
	private CategoryService categoryService;

	@Override
	@PostMapping
	public ResponseEntity<Category> create(@RequestBody Category entity) {		
			return ResponseEntity.ok(categoryService.save(entity));		
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<Category> getById(@PathVariable String id) {		
			return ResponseEntity.ok(categoryService.findById(id));		
	}

	@Override
	@GetMapping
	public ResponseEntity<List<Category>> getAll() {		
			return ResponseEntity.ok(categoryService.findAll());		
	}

	@Override
	@GetMapping("/paginate")
	public ResponseEntity<List<Category>> getAll(@RequestParam int page, @RequestParam int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<Category> update(@PathVariable String id, @RequestBody Category entity) {
		
			return ResponseEntity.ok(categoryService.update(id, entity));		
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {		
			categoryService.delete(id);
			return ResponseEntity.noContent().build();		
	}

	@Override
	@DeleteMapping("/all")
	public ResponseEntity<Void> deleteAll(@RequestBody List<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

}
