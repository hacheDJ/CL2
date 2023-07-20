package pe.edu.cibertec.CL2;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PersonaRepository extends CrudRepository<Persona, Integer>{
	List<Persona> findAll();
}
