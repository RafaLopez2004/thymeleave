package dam.services;



import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dam.model.Genero;
import dam.model.Juego;
import dam.repositories.JuegoRepository;


@Service
public class JuegoService {
	@Autowired
	private JuegoRepository juegoRepository;
	
	public List<Juego> findAll() {
		return juegoRepository.findAll();
	}
	
	public List<Juego> findAllByGenero(Genero genero) {
		return juegoRepository.findByGenero(genero);
	}
	
	public List<Juego> findAllByGenero(Long generoId) {
		return juegoRepository.findByGeneroId(generoId);
	}
	
	public Juego findById(Long id) {
		return juegoRepository.findById(id).orElse(null);
	}
	
	public Juego save(Juego juego) {
		return juegoRepository.save(juego);
	}
	
	public Juego delete(Juego juego) {
		Juego result = findById(juego.getId());
		juegoRepository.delete(result);
		return result;
	}
	
	public int numeroJuegosGenero(Genero genero) {
		return juegoRepository.findNumJuegosByGenero(genero);
	}
	
	
	/*
	 * Este método sirve para obtener un número de Juegos aleatorios.
	 * Lo realizamos en Java para abstraernos mejor de la base de datos
	 * concreta que vamos a usar.
	 * Algunos SGBDR nos permitirían usar la función RANDOM, y podríamos
	 * hacer esta consulta de forma nativa.
	 */
	public List<Juego> obtenerJuegosAleatorios(int numero) {
		// Obtenemos los ids de todos los Juegos
		List<Long> listaIds = juegoRepository.obtenerIds();
		// Los desordenamos 
		Collections.shuffle(listaIds);
		// Nos quedamos con los N primeros, con N = numero.
		listaIds = listaIds.stream().limit(numero).collect(Collectors.toList());
		// Buscamos los Juegos con esos IDs y devolvemos la lista
		return juegoRepository.findAllById(listaIds);

	}
}