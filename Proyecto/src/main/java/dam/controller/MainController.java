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
import dam.services.GeneroService;
import dam.services.JuegoService;


@Controller
public class MainController {


	@Autowired
	private GeneroService generoService;

	@Autowired
	private JuegoService juegoService;

	@GetMapping("/")
	public String index(@RequestParam(name="idGenero", required=false) Long idGenero , 
			@RequestParam(name="palabraClave", required=false) String palabraClave, Model model) {
		List<Juego> juegos;

		if(idGenero==null && palabraClave==null) {
			juegos = juegoService.obtenerJuegosAleatorios(JuegoRepository.PRODUCTOS_ALEATORIOS);
		}else if(idGenero!=null) {
			juegos = juegoService.findAllByGenero(idGenero);
		}else {
			juegos = juegoService.findAllByClave(palabraClave);
		}
		model.addAttribute("Generos", generoService.findAll());

		model.addAttribute("Juegos", juegos);

		return "index";
	}
	@GetMapping("/Juego/{id}")
	public String showDetails(@PathVariable("id") Long id, Model model) {
		Juego juego = juegoService.findById(id);
		if(juego!=null) {
			model.addAttribute("Juego", juego);
			return "detail";
		}
		return "redirect:/";
	}
}