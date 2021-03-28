package iua.edu.soa.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	//-----Relacion uno a muchos--------------
	
	//Un cliente puede tener muchas facturas, pero una factura solo puede tener un cliente
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	//Una transaccion puede tener muchas facturas, pero una factura solo puede tener una transaccion
		@ManyToOne(cascade = CascadeType.MERGE)
		@JoinColumn(name = "transaccion_id")
		private Transaccion transaccion;
}
