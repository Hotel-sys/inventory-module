package app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entities.Company;
import app.interfaces.IController;
import app.services.CompanyService;

@RestController
@RequestMapping("/api/company")
public class CompanyController implements IController<Company>{
	
	@Autowired
	private CompanyService companyService;

	@Override
	public ResponseEntity<Company> create(Company entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Company> getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<Company>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<Company>> getAll(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Company> update(String id, Company entity) {
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
