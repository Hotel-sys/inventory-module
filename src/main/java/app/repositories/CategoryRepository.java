package app.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
	
}
