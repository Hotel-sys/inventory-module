package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.StockItem;

@Repository
public interface StockItemRepository extends JpaRepository<StockItem, String> {

//	StockItem findStockItemByName(String name);
	
	List<StockItem> findByArchivedFalse();
	
}
