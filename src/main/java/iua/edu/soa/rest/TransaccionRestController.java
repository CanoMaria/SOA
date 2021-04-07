package iua.edu.soa.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iua.edu.soa.business.ITransaccionBusiness;
import iua.edu.soa.business.exception.BusinessException;
import iua.edu.soa.model.Transaccion;




@RestController
@RequestMapping(value = Constantes.URL_TRANSACTION)
public class TransaccionRestController {
	@Autowired
	private ITransaccionBusiness transaccionBusiness;
	
	@GetMapping(value = "paid/{id_client}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Transaccion>> list(@PathVariable("id_client") Long id_client) {

		try {
			return new ResponseEntity<List<Transaccion>>(transaccionBusiness.listPaid(id_client), HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<List<Transaccion>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
