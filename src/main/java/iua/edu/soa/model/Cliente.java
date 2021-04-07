package iua.edu.soa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = -2096655693932225923L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_cliente;

	@Column(length = 100,nullable = false)
	private String nombre;

	@Column(length = 100,nullable = false)
	private String apellido;
	
	@Column(length = 100,nullable = false)
	private String email;
	
	//-------Setters and Getters---------

	public long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
