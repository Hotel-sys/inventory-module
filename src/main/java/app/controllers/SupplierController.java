package app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
public class SupplierController implements IController<Supplier> {
	
	@Autowired
	private SupplierService supplierService;

	@Override
	@PostMapping
	public ResponseEntity<Supplier> create(@RequestBody Supplier entity) {
		try {
			return new ResponseEntity<Supplier>(supplierService.save(entity), HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<Supplier> getById(@PathVariable String id) {
		try {
			return ResponseEntity.ok(supplierService.findById(id));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@Override
	@GetMapping
	public ResponseEntity<List<Supplier>> getAll() {
		try {
			return ResponseEntity.ok(supplierService.findAll());
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@Override
	@GetMapping("/paginate")
	public ResponseEntity<List<Supplier>> getAll(@RequestParam int page, @RequestParam int size) {
		try {
			return ResponseEntity.ok(supplierService.findAll());
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<Supplier> update(@PathVariable String id, @RequestBody Supplier entity) {
		try {
			return ResponseEntity.ok(supplierService.update(id, entity));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		try {
			supplierService.delete(id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@Override
	@DeleteMapping("/all")
	public ResponseEntity<Void> deleteAll(@RequestBody List<String> ids) {
		try {
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
}



