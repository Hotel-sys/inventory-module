package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import app.entities.User;

public interface UserRepository extends JpaRepository<User, String> {	
	public List<User> findByNameStartingWith(String name);
	
	public List<User> findByEmailContaining(String address);
	
	@Query("SELECT u FROM User u WHERE u.department.name = :departmentName")
    List<User> findByDepartmentName(@Param("departmentName") String departmentName);
}
