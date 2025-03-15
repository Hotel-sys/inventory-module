package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import app.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, String>{
	
	public List<Department> findByNameStartingWith(String name);
	
	public List<Department> findByDescriptionContaining(String address);
}
