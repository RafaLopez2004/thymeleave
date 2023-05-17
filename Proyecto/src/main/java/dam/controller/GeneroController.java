package dam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dam.model.Genero;
import dam.services.*;



@Controller
@RequestMapping("/admin/Genero")
public class GeneroController {


	@Autowired
	private GeneroService generoService;

	@Autowired
	private JuegoService juegoService;

	@GetMapping("/")
	public String index(Model model) {					
		model.addAttribute("Generos", generoService.findAll());
		return "admin/list-Genero";
	}

	@GetMapping("/nuevo")
	public String nuevaGenero(Model model) {
		model.addAttribute("Genero", new Genero());
		return "admin/form-Genero";
	}

	@PostMapping("/nueva/submit")
	public String submitNuevaGenero(@ModelAttribute("Genero") Genero genero, Model model) {

	generoService.save(genero);

		return "redirect:/admin/Genero/";
	}

	@GetMapping("/editar/{id}")
	public String editarGenero(@PathVariable("id") Long id, Model model) {

		Genero genero = generoService.findById(id);

		if (genero != null) {
			model.addAttribute("Genero", genero);
			return "admin/form-Genero";
		} else {
			return "redirect:/admin/Genero/";
		}

	}

	@GetMapping("/borrar/{id}")
	public String borrarGenero(@PathVariable("id") Long id, Model model) {

		Genero genero = generoService.findById(id);

		if (genero != null) {

			if (juegoService.numeroJuegosGenero(genero) == 0) {
				generoService.delete(genero);				
			} else {
				return "redirect:/admin/Genero/?error=true";
			}

		} 

		return "redirect:/admin/Genero/";
	}
}

