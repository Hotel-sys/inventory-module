package app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.Company;
import app.interfaces.IService;
import app.repositories.CompanyRepository;

@Service
public class CompanyService implements IService<Company>{
	
	@Autowired
	private CompanyRepository companyRepository; 

	@Override
	public Company save(Company entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Company> saveAll(List<Company> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Company findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Company> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Company> findAll(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Company update(String id, Company entity) {
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
