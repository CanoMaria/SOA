package iua.edu.soa.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iua.edu.soa.business.IFacturaBusiness;
import iua.edu.soa.business.exception.BusinessException;
import iua.edu.soa.business.exception.NotFoundException;
import iua.edu.soa.model.Factura;



@RestController
@RequestMapping(value = Constantes.URL_INVOICE)
public class FacturaRestController {
	
	@Autowired
	private IFacturaBusiness facturaBusiness;
	
	@GetMapping(value = "/cliente={id_client}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Factura> loadByClient(@PathVariable("id_client") Long id_client) {

		try {
			return new ResponseEntity<Factura>(facturaBusiness.load(id_client), HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<Factura>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<Factura>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/paid/cliente={id_client}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Factura> paids(@PathVariable("id_client") Long id_client) {
		try {
			return new ResponseEntity<Factura>(facturaBusiness.loadPaid(id_client), HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<Factura>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<Factura>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> add(@RequestBody Factura factura) {
		try {
			facturaBusiness.add(factura);
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("location", Constantes.URL_INVOICE + '/' + factura.getId_factura());
			return new ResponseEntity<String>(responseHeaders, HttpStatus.CREATED);
		} catch (BusinessException e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
