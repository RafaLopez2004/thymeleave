package dam.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Genero {
	
	@Id
	private long id;
	
	private String nombre;
	
	@Lob
	private String descripcion;
	
	public Genero() {}
	
	public Genero(long id, String nombre, String descripcion) {
		super();
		this.id = id;
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

	public void setId(long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}
	
}
