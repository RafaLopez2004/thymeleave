package dam.services;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import dam.model.Genero;
import dam.repositories.GeneroRepository;



	@Service
	public class GeneroService {
		
		@Autowired
		private GeneroRepository repositorio;
		
		public List<Genero> findAll() {
			return repositorio.findAll();
		}	
		
		public Genero save(Genero Genero) {
			return repositorio.save(Genero);
		}
		
		public Genero findById(Long id) {
			return repositorio.findById(id).orElse(null);
		}
		
		public Genero delete(Genero genero) {
			Genero result = findById(genero.getId());
			repositorio.delete(result);
			return result;
		}

		

	}