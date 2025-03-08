package app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.Category;
import app.interfaces.IService;
import app.repositories.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoryService implements IService<Category> {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category save(Category entity) {
		return categoryRepository.save(entity);
	}

	@Override
	public List<Category> saveAll(List<Category> entities) {
		return categoryRepository.saveAll(entities);
	}

	@Override
	public Category findById(String id) throws EntityNotFoundException {
		return categoryRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException());
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public List<Category> findAll(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Category update(String id, Category entity) {
		categoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
		
		return categoryRepository.save(entity);
	}

	@Override
	public void delete(String id) {
		categoryRepository.findById(id)
			.ifPresentOrElse(entity -> categoryRepository.deleteById(id), () -> new EntityNotFoundException());
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
