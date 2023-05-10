package dam.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dam.model.Genero;

public interface GeneroRepository extends JpaRepository<Genero, Long> {
	@Query("select g from Genero g where g.destacada = true")
	public List<Genero> findDestacadas();
}