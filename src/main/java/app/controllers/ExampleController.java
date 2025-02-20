package app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entities.Example;
import app.interfaces.IController;
import app.services.ExampleService;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/example")
public class ExampleController implements IController<Example, String> {

	@Autowired
	ExampleService exampleService;
	
	@Override
	@PostMapping()
	public ResponseEntity<Example> create(@RequestBody Example example) {
		try {
			Example result = exampleService.save(example);			
		
			return ResponseEntity.created(null).body(result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.badRequest().build();
		}
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<Example> getById(@PathVariable String id) {
		try {
			Example result = exampleService.findById(id);
			
			return ResponseEntity.ok(result);
		} catch (EntityNotFoundException en) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@Override
	@GetMapping()
	public ResponseEntity<List<Example>> getAll() {
		try {
			return ResponseEntity.ok(exampleService.findAll());
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@Override
	public ResponseEntity<List<Example>> getAll(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Example> update(String id, Example entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> deleteAll(List<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

}
