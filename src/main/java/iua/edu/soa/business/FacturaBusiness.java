package iua.edu.soa.business;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iua.edu.soa.business.exception.BusinessException;
import iua.edu.soa.business.exception.NotFoundException;
import iua.edu.soa.model.Factura;
import iua.edu.soa.model.Level;
import iua.edu.soa.model.persistence.FacturaRepository;

@Service
public class FacturaBusiness implements IFacturaBusiness {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private FacturaRepository facturaDAO;

	
	@Override
	public Factura add(Factura factura) throws BusinessException {
		try {
			return facturaDAO.save(factura);
		} catch (Exception e) {
			throw new BusinessException(e);
		}	
	}
	
	@Override
	public Factura changeStatus() throws BusinessException, NotFoundException {
		Long id_factura=(long) 1;
		Factura factura;
		Level estado=null;
		try {
			factura=loadById(id_factura);
			factura.setEstado(estado.PAGADA);
			
		} catch (Exception e) {
			throw new BusinessException(e);
		}		
		
		return facturaDAO.save(factura);
	}


	@Override
	public Factura loadById(Long id_factura) throws NotFoundException, BusinessException {
		Optional<Factura> op;
		try {
			op = facturaDAO.findById(id_factura);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
		if (!op.isPresent()) {
			throw new NotFoundException("La factura con el id " + id_factura + " no se encuentra en la BD");
		}
		return op.get();
	}
	@Override
	public Factura load(Long id_cliente) throws NotFoundException, BusinessException {
		Optional<Factura> op;
		try {
			op = facturaDAO.findByClientId(id_cliente);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
		if (!op.isPresent()) {
			throw new NotFoundException("La factura con el id " + id_cliente + " no se encuentra en la BD");
		}
		return op.get();
	}
	@Override
	public Factura loadPaid(Long id_cliente) throws NotFoundException, BusinessException {
		Optional<Factura> op;
		try {
			op = facturaDAO.findPaidsByClientId(id_cliente);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
		if (!op.isPresent()) {
			throw new NotFoundException("La factura con el id " + id_cliente + " no se encuentra en la BD");
		}
		return op.get();
	}

}
