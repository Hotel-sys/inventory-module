package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.StockArchive;

@Repository
public interface StockArchiveRepository extends JpaRepository<StockArchive, String> {

}
