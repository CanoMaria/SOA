package iua.edu.soa.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "transaccion")
public class Transaccion implements Serializable{

	private static final long serialVersionUID = 6654850869312988877L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_transaccion;
	
	@Column(length = 100, nullable = false)
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date fechaTransaccion;
	
	//-----Relaciones -------------
	
	//Cada transaccion tiene una factura
	@OneToOne
	@JoinColumn(name = "factura", updatable = false, nullable = false)
	private Factura factura;
	
	//Cada transaccion tiene un cliente
	@OneToOne
	@JoinColumn(name = "cliente", updatable = false, nullable = false)
	private Cliente cliente;	
	
	
//------Setters and Getters----------
	public long getId_transaccion() {
		return id_transaccion;
	}

	public void setId_transaccion(long id_transaccion) {
		this.id_transaccion = id_transaccion;
	}

	public Date getFechaTransaccion() {
		return fechaTransaccion;
	}

	public void setFechaTransaccion(Date fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	

}
