package app.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entities.StockArchive;
import app.interfaces.IController;

@RestController
@RequestMapping("/api/stockarchives")
public class StockArchiveController implements IController<StockArchive> {

	@Override
	public ResponseEntity<StockArchive> create(StockArchive entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<StockArchive> getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<StockArchive>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<StockArchive>> getAll(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<StockArchive> update(String id, StockArchive entity) {
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
