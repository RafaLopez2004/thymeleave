package dam.controller;

import javax.validation.Valid;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dam.model.Juego;
import dam.services.GeneroService;
import dam.services.JuegoService;
import dam.services.PlataformaService;



@Controller
@RequestMapping("/admin/Juego")
public class JuegoController {

	@Autowired
	private JuegoService juegoService;

	@Autowired
	private GeneroService generoService;

	@Autowired
	private PlataformaService plataformaService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("Juegos", juegoService.findAll());
		return "admin/list-Juego";
	}	
	@GetMapping("/nuevo")
	public String nuevoJuego(Model model) {
		model.addAttribute("Juego",new Juego());
		model.addAttribute("Genero",this.generoService.findAll());
		model.addAttribute("Plataforma",this.plataformaService.findAll());
		return "admin/form-Juego";
	}

	@PostMapping("/nuevo/submit")
	public String submitNuevoJuego(@Valid Juego juego, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("Genero", generoService.findAll());
			return "admin/form-Juego";
		} else {
			juegoService.save(juego);
			return "redirect: /admin/Juego/";

		}

	}

	@GetMapping("/editar/{id}")
	public String editarJuego(@PathVariable("id") Long id, Model model) {

		Juego Juego = juegoService.findById(id);

		if (Juego != null) {
			model.addAttribute("Juego", Juego);
			model.addAttribute("Generos", generoService.findAll());
			return "admin/form-Juego";
		} else {
			return "redirect:/admin/Juego/";
		}

	}

	@GetMapping("/borrar/{id}")
	public String borrarJuego(@PathVariable("id") Long id, Model model) {

		Juego Juego = juegoService.findById(id);

		if (Juego != null) {
			juegoService.delete(Juego);
		}

		return "redirect:/admin/Juego/";

	}
}

