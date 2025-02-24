package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, String>{

}
