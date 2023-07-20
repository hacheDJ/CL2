package pe.edu.cibertec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import pe.edu.cibertec.repository.PersonaRepository;
import pe.edu.cibertec.model.Persona;

@Controller
public class PersonaController {
	
	PersonaRepository pr;
	
	public PersonaController(PersonaRepository pr){
		this.pr = pr;
	}

	@GetMapping("persona/listar")
	public String listar(Model model) {
		List<Persona> personas = pr.findAll();
		model.addAttribute("title", "Listado de Personas");
		model.addAttribute("personas", personas);
		
		return "persona/listar";
	}
	
	@GetMapping("persona/registrar")
	public String frmRegistrar(Model model) {
		Persona persona = new Persona();
		model.addAttribute("personaForm", persona);
		
		return "persona/registrar";
	}
	
	@GetMapping("persona/registrar")
	public String registrar(Persona persona) {
		pr.save(persona);
		
		return "redirect:/persona/listar";
	}
	
	@GetMapping("persona/{id}/actualizar")
	public String frmActualizar(@PathVariable Integer id, Model model) {
		Optional<Persona> personaOptional = pr.findById(id);
		
		if(personaOptional.isEmpty()) {
			return "404";
		}
		
		Persona persona = personaOptional.get();
		model.addAttribute("persona", persona);
		
		return "persona/actualizar";
	}
	
	@GetMapping("persona/{id}")
	public String actualizar(@PathVariable Integer id, Persona personaFrm) {
		Optional<Persona> personaOptional = pr.findById(id);
		
		if(personaOptional.isEmpty()) {
			return "404";
		}
		
		Persona persona = personaOptional.get();
		persona.setNombre(personaFrm.getNombre());
		persona.setApellido(personaFrm.getApellido());
		persona.setEdad(personaFrm.getEdad());
		pr.save(persona);
		
		return "redirect:/persona/listar";
	}
	
	@GetMapping("persona/{id}/eliminar")
	public String eliminar(@PathVariable Integer id) {
		pr.deleteById(id);
		
		return "redirect:/persona/listar";
	}
}
