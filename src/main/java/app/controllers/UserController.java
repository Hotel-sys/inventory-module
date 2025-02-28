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
import org.springframework.web.bind.annotation.RestController;

import app.entities.User;
import app.interfaces.IController;
import app.services.UserService;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/user")
public class UserController implements IController<User>{
	
	@Autowired
	private UserService userService;

	@Override
	@PostMapping("/create")
	public ResponseEntity<User> create(@RequestBody User entity) {
		try {
			User u = this.userService.save(entity);
			return new ResponseEntity<>(u, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);			
		}
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable String id) {
		try {
			User u = this.userService.findById(id);
			return ResponseEntity.ok(u);			
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@Override
	@GetMapping()
	public ResponseEntity<List<User>> getAll() {
		try {
			List<User> users= this.userService.findAll();
			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);			
		}
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
		try {
			User u = this.userService.update(id, entity);
			return new ResponseEntity<>(u, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);			
		}
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		try {
			this.userService.delete(id);
			return ResponseEntity.ok(null);						
		} catch (EntityNotFoundException e) {
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

}
