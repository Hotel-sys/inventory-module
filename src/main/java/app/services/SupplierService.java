package app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.Supplier;
import app.interfaces.IService;
import app.repositories.SupplierRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class SupplierService implements IService<Supplier> {
	
	@Autowired
	private SupplierRepository supplierRepository;

	@Override
	public Supplier save(Supplier entity) {
		return supplierRepository.save(entity);
	}

	@Override
	public List<Supplier> saveAll(List<Supplier> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Supplier findById(String id) {
		return supplierRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());

	}

	@Override
	public List<Supplier> findAll() {
		return supplierRepository.findAll();
	}

	@Override
	public List<Supplier> findAll(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Supplier update(String id, Supplier entity) {
		supplierRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
		
		return supplierRepository.save(entity);
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
