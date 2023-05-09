package dam.model;

import java.util.HashSet;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;

public class Genero {
	
	@Id
	String nombre;
	
	@Lob
	String descripcion;
	
	@OneToMany(mappedBy="juego", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER)
	private HashSet<Juego> juegos = new HashSet<Juego>();
	
	public Genero(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public HashSet<Juego> getJuegos() {
		return juegos;
	}
	
}
