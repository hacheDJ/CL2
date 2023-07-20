package pe.edu.cibertec.CL2;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/persona")
public class PersonaController {

	PersonaRepository pr;
	
	public PersonaController(PersonaRepository pr){
		this.pr = pr;
	}

	@GetMapping
	public String listar(Model model) {
		List<Persona> personas = pr.findAll();
		model.addAttribute("title", "Listado de Personas");
		model.addAttribute("personas", personas);
		
		return "persona/listar";
	}
	
	@GetMapping("/registrar")
	public String frmRegistrar(Model model) {
		model.addAttribute("title", "Registro de Personas");
		Persona persona = new Persona();
		model.addAttribute("personaForm", persona);
		
		return "persona/frmRegistrar";
	}
	
	@PostMapping("registrar")
	public String registrar(Persona persona) {
		pr.save(persona);
		
		return "redirect:/persona";
	}
	
	@GetMapping("/{id}/actualizar")
	public String frmActualizar(@PathVariable Integer id, Model model) {
		model.addAttribute("title", "Actualizar persona");
		Optional<Persona> personaOptional = pr.findById(id);

		if(personaOptional.isEmpty()) {
			return "404";
		}
		
		Persona persona = personaOptional.get();
		model.addAttribute("persona", persona);
		
		return "persona/frmActualizar";
	}
	
	@PostMapping("/{id}/actualizar")
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
		
		return "redirect:/persona";
	}
	
	@PostMapping("/{id}/eliminar")
	public String eliminar(@PathVariable Integer id) {
		pr.deleteById(id);
		
		return "redirect:/persona";
	}
}
