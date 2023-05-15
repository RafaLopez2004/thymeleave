package dam.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;

@Entity
public class Plataforma {
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	String nombrePlataforma;
	
	@Lob
    String descripcion;

	public Plataforma() {}
	
	public Plataforma(Long id, String nombrePlataforma, String descripcion) {
		super();
		this.id = id;
		this.nombrePlataforma = nombrePlataforma;
		this.descripcion = descripcion;
	}

	public void setNombrePlataforma(String nombrePlataforma) {
		this.nombrePlataforma = nombrePlataforma;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombrePlataforma() {
		return nombrePlataforma;
	}

	public void setId(Long id) {
		this.id = id;
	} 
	
	public Long getId() {
		return id;
	}
}
