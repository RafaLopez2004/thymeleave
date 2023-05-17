package dam.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dam.model.Genero;
import dam.model.Juego;

public interface JuegoRepository extends JpaRepository<Juego, Long> {
	public final int PRODUCTOS_ALEATORIOS=20;
	public List<Juego> findByGenero(Genero genero);
	
	@Query("select p.id from Juego p")
	public List<Long> obtenerIds();
	
	@Query("select p from Juego p where p.genero.id = ?1")
	public List<Juego> findByGeneroId(Long generoId);
	
	@Query("select count(p) from Juego p where p.genero = ?1")
	public int findNumJuegosByGenero(Genero genero);
	
	/**
	 * 
	 * @param clave
	 * @return
	 */
	@Query("select p from Juego p where nombre like %?1%")
	public List<Juego> findByClave(String clave);
	
	@Query("select p from Juego p where pvp = ?1")
	public List<Juego> findByClave(float clave);
	

}