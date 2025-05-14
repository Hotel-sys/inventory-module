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

import app.entities.StockItem;
import app.interfaces.IController;
import app.services.StockItemService;

@RestController
@RequestMapping("/api/stockitems")
@CrossOrigin("*")
@PreAuthorize("hasAuthority('ADMIN')")
public class StockItemController implements IController<StockItem> {

	@Autowired
	private StockItemService stockItemService;
	
	@Override
	@PostMapping
	public ResponseEntity<StockItem> create(@RequestBody StockItem entity) {
			return ResponseEntity.ok(stockItemService.save(entity));
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<StockItem> getById(@PathVariable String id) {
			return ResponseEntity.ok(stockItemService.findById(id));
	}

	@Override
	@GetMapping
	public ResponseEntity<List<StockItem>> getAll() {
			return ResponseEntity.ok(stockItemService.findAll());
	}

	@Override
	@GetMapping("/paginate")
	public ResponseEntity<List<StockItem>> getAll(@RequestParam int page, @RequestParam int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<StockItem> update(@PathVariable String id, @RequestBody StockItem entity) {
			return ResponseEntity.ok(stockItemService.update(id, entity));
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
			stockItemService.delete(id);			
			return ResponseEntity.noContent().build();		
	}

	@Override
	@DeleteMapping("/all")
	public ResponseEntity<Void> deleteAll(@RequestBody List<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

}
