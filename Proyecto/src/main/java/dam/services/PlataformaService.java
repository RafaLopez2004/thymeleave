package dam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dam.model.Plataforma;
import dam.repositories.PlataformaRepository;

@Service
public class PlataformaService {
	@Autowired
	private PlataformaRepository repositorio;
	
	public List<Plataforma> findAll() {
		return repositorio.findAll();
	}	
	
	public Plataforma save(Plataforma Plataforma) {
		return repositorio.save(Plataforma);
	}
	
	public Plataforma findById(Long id) {
		return repositorio.findById(id).orElse(null);
	}
	
	public Plataforma delete(Plataforma Plataforma) {
		Plataforma result = findById(Plataforma.getId());
		repositorio.delete(result);
		return result;
	}
}
