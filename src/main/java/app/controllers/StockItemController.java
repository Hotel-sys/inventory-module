package app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import app.entities.StockItem;
import app.interfaces.IController;
import app.services.StockItemService;

@RestController
@RequestMapping("/api/stockitems")
public class StockItemController implements IController<StockItem> {

	@Autowired
	private StockItemService stockItemService;
	
	@Override
	@PostMapping
	public ResponseEntity<StockItem> create(StockItem entity) {
		try {
			return ResponseEntity.ok(stockItemService.save(entity));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<StockItem> getById(@PathVariable String id) {
		try {
			return ResponseEntity.ok(stockItemService.findById(id));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@Override
	@GetMapping
	public ResponseEntity<List<StockItem>> getAll() {
		try {
			return ResponseEntity.ok(stockItemService.findAll());
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
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
		try {
			return ResponseEntity.ok(stockItemService.update(id, entity));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		try {
			stockItemService.delete(id);
			
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@Override
	@DeleteMapping("/all")
	public ResponseEntity<Void> deleteAll(@RequestBody List<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

}
