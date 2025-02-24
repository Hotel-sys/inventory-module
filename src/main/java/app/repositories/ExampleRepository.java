package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.Example;

@Repository
public interface ExampleRepository extends JpaRepository<Example, String> {

}
