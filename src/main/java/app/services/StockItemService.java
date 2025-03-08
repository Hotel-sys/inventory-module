package app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.StockArchive;
import app.entities.StockItem;
import app.interfaces.IService;
import app.repositories.StockArchiveRepository;
import app.repositories.StockItemRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class StockItemService implements IService<StockItem> {
	
	@Autowired
	private StockItemRepository stockItemRepository;
	

	@Override
	public StockItem save(StockItem entity) {
	
		StockItem stockItem = stockItemRepository.save(entity);
		
		return stockItem;
		
	}

	@Override
	public List<StockItem> saveAll(List<StockItem> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StockItem findById(String id) {
		return stockItemRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
	}

	@Override
	public List<StockItem> findAll() {
		return stockItemRepository.findByStockItemArchivedFalse();
	}

	@Override
	public List<StockItem> findAll(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public StockItem update(String id, StockItem entity) {
		stockItemRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
		
		return stockItemRepository.save(entity);
	}

	@Override
	public void delete(String id) {
		stockItemRepository.findById(id)
			.ifPresentOrElse(entity -> stockItemRepository.deleteById(id), () -> new EntityNotFoundException());
		
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
