package dam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import dam.Helper;
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
		Helper helper = new Helper();
		if(idGenero==null && palabraClave==null) {
			juegos = juegoService.obtenerJuegosAleatorios(JuegoRepository.PRODUCTOS_ALEATORIOS);
			helper.setFiltro("Nada");
		}else if(idGenero!=null) {
			juegos = juegoService.findAllByGenero(idGenero);
			helper.setFiltro("Genero");
		}else {
			// Convertimos la clave a un numero, si salta excepcion significa que no es un numero, 
			// por lo que estamos buscando por el nombre y no el precio
			try {
				juegos = juegoService.findAllByClave(Float.parseFloat(palabraClave));
				helper.setFiltro("Precio");
			} catch (NumberFormatException e) {
				juegos = juegoService.findAllByClave(palabraClave);
				helper.setFiltro("Nombre juego");
			}
		}
		model.addAttribute("Generos", generoService.findAll());

		model.addAttribute("Juegos", juegos);
		
		model.addAttribute("Filtro", helper);
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