package app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entities.Department;
import app.interfaces.IController;
import app.services.DepartmentService;

@RestController
@RequestMapping("/api/department")
public class DepartmentController implements IController<Department>{
	
	@Autowired
	private DepartmentService departmentService;

	@Override
	public ResponseEntity<Department> create(Department entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Department> getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<Department>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<Department>> getAll(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Department> update(String id, Department entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> deleteAll(List<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

}
