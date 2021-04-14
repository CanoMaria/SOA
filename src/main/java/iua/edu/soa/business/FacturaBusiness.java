package iua.edu.soa.business;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iua.edu.soa.business.exception.BusinessException;
import iua.edu.soa.business.exception.NotFoundException;
import iua.edu.soa.model.Factura;
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
	public Factura load(Long id_cliente) throws NotFoundException, BusinessException {
		Optional<Factura> op;
		try {
			op = facturaDAO.findByClientId(id_cliente);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
		if (!op.isPresent()) {
			throw new NotFoundException("El Producto con el id " + id_cliente + " no se encuentra en la BD");
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
			throw new NotFoundException("El Producto con el id " + id_cliente + " no se encuentra en la BD");
		}
		return op.get();
	}

}
