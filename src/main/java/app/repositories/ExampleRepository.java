package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entities.Example;

public interface ExampleRepository extends JpaRepository<Example, String> {

}
