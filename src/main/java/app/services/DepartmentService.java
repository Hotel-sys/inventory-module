package app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.Department;
import app.interfaces.IService;
import app.repositories.DepartmentRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class DepartmentService implements IService<Department>{
	
	@Autowired
	private DepartmentRepository departmentRepository; 

	@Override
	public Department save(Department entity) {
		return this.departmentRepository.save(entity);
	}

	@Override
	public List<Department> saveAll(List<Department> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department findById(String id) {
		return this.departmentRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException());
	}

	@Override
	public List<Department> findAll() {
		return this.departmentRepository.findAll();
	}

	@Override
	public List<Department> findAll(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Department update(String id, Department entity) {
		this.departmentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
		
		return this.departmentRepository.save(entity);
	}

	@Override
	public void delete(String id) {
		this.departmentRepository.findById(id)
			.ifPresentOrElse((d) -> this.departmentRepository.deleteById(id), 
			() -> new EntityNotFoundException()	
		);	
		
	}

	@Override
	public void deleteAll(List<String> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	
	public List<Department> findByNameStartingWith(String name) {
		return this.departmentRepository.findByNameStartingWith(name);
	}
	
	public List<Department> findByDescriptionContaining(String address) {
		return this.departmentRepository.findByDescriptionContaining(address);
	}

}
