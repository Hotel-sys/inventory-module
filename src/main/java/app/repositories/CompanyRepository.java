package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, String>{
	public List<Company> findByNameStartingWith(String name);
	
	public List<Company> findByAddressContaining(String address);
	
	
}
