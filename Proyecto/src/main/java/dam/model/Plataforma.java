package dam.model;

import java.util.HashSet;

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
	
	String imagen;
	
    float pvp;
    
    float descuento;

	@OneToMany(mappedBy="juego", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER)
	private HashSet<Juego> juegos = new HashSet<Juego>();


	public Plataforma(Long id, String nombrePlataforma, String descripcion, String imagen, float pvp, float descuento) {
		super();
		this.id = id;
		this.nombrePlataforma = nombrePlataforma;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.pvp = pvp;
		this.descuento = descuento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombrePlataforma() {
		return nombrePlataforma;
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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public float getPvp() {
		return pvp;
	}

	public void setPvp(float pvp) {
		this.pvp = pvp;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}
 
}
