package iua.edu.soa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iua.edu.soa.business.IFacturaBusiness;
import iua.edu.soa.business.ITransaccionBusiness;
import iua.edu.soa.business.exception.BusinessException;
import iua.edu.soa.business.exception.NotFoundException;
import iua.edu.soa.model.Factura;
import iua.edu.soa.model.Transaccion;

@RestController
@RequestMapping(value = Constantes.URL_TRANSACTION)
public class TransaccionRestController {
	
	@Autowired
	private ITransaccionBusiness transaccionBusiness;
	
	@Autowired
	private IFacturaBusiness facturaBusiness;
	
	@PostMapping(value = "/pay", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> add(@RequestBody Transaccion transaccion) throws NotFoundException {
		try {
			facturaBusiness.changeStatus();
			transaccionBusiness.add(transaccion);
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("location", Constantes.URL_TRANSACTION + '/' + transaccion.getId_transaccion());
			return new ResponseEntity<String>(responseHeaders, HttpStatus.CREATED);
		} catch (BusinessException e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
