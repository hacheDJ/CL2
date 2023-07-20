package pe.edu.cibertec.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pe.edu.cibertec.model.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Integer>{
	List<Persona> findAll();
}
