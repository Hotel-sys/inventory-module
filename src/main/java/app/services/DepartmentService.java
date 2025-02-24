package app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.Department;
import app.interfaces.IService;
import app.repositories.DepartmentRepository;

@Service
public class DepartmentService implements IService<Department>{
	
	@Autowired
	private DepartmentRepository departmentRepository; 

	@Override
	public Department save(Department entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> saveAll(List<Department> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return null;
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
