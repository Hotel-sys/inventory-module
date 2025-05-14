package app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

import app.entities.Supplier;
import app.interfaces.IController;
import app.services.CategoryService;
import app.services.SupplierService;

@RestController
@RequestMapping("/api/suppliers")
@CrossOrigin("*")
@PreAuthorize("hasAuthority('ADMIN')")
public class SupplierController implements IController<Supplier> {
	
	@Autowired
	private SupplierService supplierService;

	@Override
	@PostMapping
	public ResponseEntity<Supplier> create(@RequestBody Supplier entity) {
			return new ResponseEntity<Supplier>(supplierService.save(entity), HttpStatus.CREATED);
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<Supplier> getById(@PathVariable String id) {
			return ResponseEntity.ok(supplierService.findById(id));
	}

	@Override
	@GetMapping
	public ResponseEntity<List<Supplier>> getAll() {
			return ResponseEntity.ok(supplierService.findAll());
	}

	@Override
	@GetMapping("/paginate")
	public ResponseEntity<List<Supplier>> getAll(@RequestParam int page, @RequestParam int size) {
			return ResponseEntity.ok(supplierService.findAll());
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<Supplier> update(@PathVariable String id, @RequestBody Supplier entity) {
			return ResponseEntity.ok(supplierService.update(id, entity));
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
			supplierService.delete(id);
			return ResponseEntity.noContent().build();
	}

	@Override
	@DeleteMapping("/all")
	public ResponseEntity<Void> deleteAll(@RequestBody List<String> ids) {
			return ResponseEntity.noContent().build();
	}
}



