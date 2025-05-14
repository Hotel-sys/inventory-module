package app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import app.entities.Department;
import app.interfaces.IController;
import app.services.DepartmentService;

@RestController
@RequestMapping("/api/department")
@CrossOrigin("*")
@PreAuthorize("hasAuthority('ADMIN')")
public class DepartmentController implements IController<Department>{
	
	@Autowired
	private DepartmentService departmentService;

	@Override
	@PostMapping("/teste")
	public ResponseEntity<Department> create(@RequestBody Department entity) {
			Department d = this.departmentService.save(entity);
			return ResponseEntity.ok(d);
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<Department> getById(@PathVariable String id) {
			Department d = this.departmentService.findById(id);
			return ResponseEntity.ok(d);
	}

	@Override
	@GetMapping()
	public ResponseEntity<List<Department>> getAll() {		
			List<Department> d = this.departmentService.findAll();
			return ResponseEntity.ok(d);
	}

	@Override
	@GetMapping("/paginate")
	public ResponseEntity<List<Department>> getAll(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<Department> update(@PathVariable String id, @RequestBody Department entity) {		
			Department d = this.departmentService.update(id, entity);
			return ResponseEntity.ok(d);
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {		
			this.departmentService.delete(id);
			return ResponseEntity.ok(null);		
	}

	@Override
	@DeleteMapping("/all")
	public ResponseEntity<Void> deleteAll(List<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@GetMapping("/findByNameStartingWith")
	public ResponseEntity<Department> findByNameStartingWith(@RequestParam String name) {
			this.departmentService.findByNameStartingWith(name);
			return ResponseEntity.ok(null);		
	}
	
	@GetMapping("/findByDescriptionContaining")
	public ResponseEntity<Department> findByDescriptionContaining(@RequestParam String address) {		
			this.departmentService.findByDescriptionContaining(address);
			return ResponseEntity.ok(null);		
	}
	

}
