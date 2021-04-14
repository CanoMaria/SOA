package iua.edu.soa.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.springframework.format.annotation.DateTimeFormat;

enum Level {
	EMITIDA,
	PAGADA, 
	VENCIDA, 
	ANULADA
	}
@Entity
@Table(name = "factura")
public class Factura implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7932345257518151931L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_factura;
	
	@Column(length = 100, nullable = false)
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date fechaEmision;
	
	@Column(length = 100, nullable = false)
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date fechaVencimiento;
	
	@Column(length = 100, nullable = false)
	private double monto;
	
	@Column(length = 100, nullable = false)
	private Level estado;
	
	
	//-------Setters and Getters-----------------
	
	public long getId_factura() {
		return id_factura;
	}

	public void setId_factura(long id_factura) {
		this.id_factura = id_factura;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public Level getEstado() {
		return estado;
	}

	public void setEstado(Level estado) {
		this.estado = estado;
	}
	//una factura tiene un cliente pero un cliente muchas facturas
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Cliente cliente;
	
	
}
