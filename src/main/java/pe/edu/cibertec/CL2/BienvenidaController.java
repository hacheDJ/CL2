package pe.edu.cibertec.CL2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BienvenidaController {
	
	@GetMapping("/")
	public String bienvenida(Model model) {
		model.addAttribute("title", "Bienvenidos a mi página con Spring");
		return "bienvenida";
	}
	
}
