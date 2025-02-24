package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, String>{

}
