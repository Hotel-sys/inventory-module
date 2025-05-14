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

import app.entities.Company;
import app.interfaces.IController;
import app.services.CompanyService;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/company")
@CrossOrigin("*")
@PreAuthorize("hasAuthority('SUPERADMIN')")
public class CompanyController implements IController<Company>{
	
	@Autowired
	private CompanyService companyService;

	@Override
	@PostMapping()
	public ResponseEntity<Company> create(@RequestBody Company entity) {		
			Company c = this.companyService.save(entity);
			return ResponseEntity.ok(c);		
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<Company> getById(@PathVariable String id) {		
			Company c = this.companyService.findById(id);
			return ResponseEntity.ok(c);			
	}

	@Override
	@GetMapping()
	public ResponseEntity<List<Company>> getAll() {		
			List<Company> companies = this.companyService.findAll();
			return ResponseEntity.ok(companies);		
		
	}

	@Override
	@GetMapping("/paginate")
	public ResponseEntity<List<Company>> getAll(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<Company> update(@PathVariable String id, @RequestBody Company entity) {		
			Company c = this.companyService.update(id, entity);
			return ResponseEntity.ok(c);		
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {		
			this.companyService.delete(id);
			return ResponseEntity.ok(null);		
	}

	@Override
	@DeleteMapping("/all")
	public ResponseEntity<Void> deleteAll(List<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@GetMapping("/findByNameStartingWith")
	public ResponseEntity<List<Company>> findByNameStartingWith(@RequestParam String name) {		
			List<Company> companies = this.companyService.findByNameStartingWith(name);
			return ResponseEntity.ok(companies);		
	}
	
	@GetMapping("/findByAddressContaining")
	public ResponseEntity<List<Company>> findByAddressContaining(@RequestParam String address) {		
			List<Company> companies = this.companyService.findByAddressContaining(address);
			return ResponseEntity.ok(companies);		
	}

}
