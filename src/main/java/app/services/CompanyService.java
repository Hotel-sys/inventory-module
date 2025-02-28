package app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.Company;
import app.interfaces.IService;
import app.repositories.CompanyRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CompanyService implements IService<Company>{
	
	@Autowired
	private CompanyRepository companyRepository; 

	@Override
	public Company save(Company entity) {
		return this.companyRepository.save(entity);
	}

	@Override
	public List<Company> saveAll(List<Company> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Company findById(String id) {
		return this.companyRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException());
	}

	@Override
	public List<Company> findAll() {
		return this.companyRepository.findAll();
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
		this.companyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
		
		return this.companyRepository.save(entity);
	}

	@Override
	public void delete(String id) {
		this.companyRepository.findById(id).ifPresentOrElse(
				(c) -> this.companyRepository.deleteById(id), 
				() ->  new EntityNotFoundException());		
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
