package app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.StockArchive;
import app.interfaces.IService;
import app.repositories.StockArchiveRepository;

@Service
public class StockArchiveService implements IService<StockArchive> {

	@Autowired
	StockArchiveRepository stockArchiveRepository;
	
	
	@Override
	public StockArchive save(StockArchive entity) {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		return null;
=======
		return entity;
>>>>>>> 9cb2cd39efa980e5fcf040dd930a3fec3b7b176f
	}

	@Override
	public List<StockArchive> saveAll(List<StockArchive> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StockArchive findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StockArchive> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StockArchive> findAll(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public StockArchive update(String id, StockArchive entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(List<String> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}
