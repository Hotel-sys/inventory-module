package app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.Example;
import app.interfaces.IService;
import app.repositories.ExampleRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ExampleService implements IService<Example> {
	
	@Autowired
	ExampleRepository exampleRepository;

	@Override
	public Example save(Example entity) {
		Example newEntity = Example.builder().ping(entity.getPing()).build();
		
		return exampleRepository.save(newEntity);
	}

	@Override
	public List<Example> saveAll(List<Example> entities) {
		return null;
	}

	@Override
	public Example findById(String id) throws EntityNotFoundException {
		return exampleRepository
				.findById(id)
				.orElseThrow(() -> new EntityNotFoundException());
	}

	@Override
	public List<Example> findAll() {
		return exampleRepository.findAll();
	}

	@Override
	public List<Example> findAll(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Example update(String id, Example entity) {
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
