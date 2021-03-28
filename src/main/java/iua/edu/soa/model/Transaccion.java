package iua.edu.soa.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	

}
