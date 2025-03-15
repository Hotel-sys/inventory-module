package app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.entities.Company;
import app.entities.Department;
import app.interfaces.IController;
import app.services.DepartmentService;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/department")
public class DepartmentController implements IController<Department>{
	
	@Autowired
	private DepartmentService departmentService;

	@Override
	@PostMapping()
	public ResponseEntity<Department> create(Department entity) {
		try {
			Department d = this.departmentService.save(entity);
			return ResponseEntity.ok(d);			
		} catch(EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<Department> getById(String id) {
		try {
			Department d = this.departmentService.findById(id);
			return ResponseEntity.ok(d);			
		} catch(EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@Override
	@GetMapping()
	public ResponseEntity<List<Department>> getAll() {
		try {
			List<Department> d = this.departmentService.findAll();
			return ResponseEntity.ok(d);			
		} catch(EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@Override
	@GetMapping("/paginate")
	public ResponseEntity<List<Department>> getAll(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<Department> update(String id, Department entity) {
		try {
			Department d = this.departmentService.update(id, entity);
			return ResponseEntity.ok(d);			
		} catch(EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(String id) {
		try {
			this.departmentService.delete(id);
			return ResponseEntity.ok(null);			
		} catch(EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@Override
	@DeleteMapping("/all")
	public ResponseEntity<Void> deleteAll(List<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@GetMapping("/findByNameStartingWith")
	public ResponseEntity<Department> findByNameStartingWith(@RequestParam String name) {
		try {
			this.departmentService.findByNameStartingWith(name);
			return ResponseEntity.ok(null);			
		} catch(EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("/findByDescriptionContaining")
	public ResponseEntity<Department> findByDescriptionContaining(@RequestParam String address) {
		try {
			this.departmentService.findByDescriptionContaining(address);
			return ResponseEntity.ok(null);			
		} catch(EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	

}
