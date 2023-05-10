package dam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import dam.model.Juego;
import dam.repositories.JuegoRepository;
import dam.services.JuegoService;


@Controller
public class MainController {


	@Autowired
	private GeneroService categoryService;

	@Autowired
	private JuegoService juegoService;

	@GetMapping("/")
	public String index(@RequestParam(name="idGenero", required=false) Long idGenero, Model model) {
		List<Juego> juegos;

		if(idGenero==null) {
			juegos = juegoService.obtenerJuegosAleatorios(JuegoRepository.PRODUCTOS_ALEATORIOS);
		}else {
			juegos = juegoService.findAllByGenero(idGenero);
		}

		model.addAttribute("Generos", categoryService.findAll());

		model.addAttribute("productos", juegos);

		return "index";
	}
/*	@GetMapping("/producto/{id}")
	public String showDetails(@PathVariable("id") Long id, Model model) {
		Producto producto = productService.findById(id);
		if(producto!=null) {
			model.addAttribute(producto);
			return "detail";
		}
		return "redirect:/";
	}*/
}