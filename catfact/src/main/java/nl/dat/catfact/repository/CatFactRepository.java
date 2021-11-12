package nl.dat.catfact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nl.dat.catfact.model.CatFactModel;

/**
 * CatFactRepository is used to do operations such as save,retrieve in catfact
 * table using JpaRepository
 * 
 * @author Nisha
 *
 */
@Repository
public interface CatFactRepository extends JpaRepository<CatFactModel, Long> {

}
