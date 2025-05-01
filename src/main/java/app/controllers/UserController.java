package app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

import app.entities.User;
import app.interfaces.IController;
import app.services.UserService;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins="*")
public class UserController implements IController<User>{
	
	@Autowired
	private UserService userService;

	@Override
	@PostMapping()
	public ResponseEntity<User> create(@RequestBody User entity) {
			User u = this.userService.save(entity);
			return new ResponseEntity<>(u, HttpStatus.OK);
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable String id) {
			User u = this.userService.findById(id);
			return ResponseEntity.ok(u);
	}

	@Override
	@GetMapping()
	public ResponseEntity<List<User>> getAll() {
			List<User> users= this.userService.findAll();
			return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@Override
	@GetMapping("/paginate")
	public ResponseEntity<List<User>> getAll(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<User> update(@PathVariable String id, @RequestBody User entity) {
			User u = this.userService.update(id, entity);
			return new ResponseEntity<>(u, HttpStatus.OK);
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
			this.userService.delete(id);
			return ResponseEntity.ok(null);
	}

	@Override
	@DeleteMapping("/all")
	public ResponseEntity<Void> deleteAll(List<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@GetMapping("/findByNameStartingWith")
	public ResponseEntity<List<User>> findByNameStartingWith(@RequestParam String name) {
			this.userService.findByNameStartingWith(name);
			return ResponseEntity.ok(null);
	}
	
	@GetMapping("/findByEmailContaining")
	public ResponseEntity<List<User>> findByEmailContaining(@RequestParam String email) {
			this.userService.findByEmailContaining(email);
			return ResponseEntity.ok(null);
	}
	
	@GetMapping("/greeting")
	public ResponseEntity<String> greeting() {
	    return ResponseEntity.ok("Hello, welcome to the User API!");
	}

}
