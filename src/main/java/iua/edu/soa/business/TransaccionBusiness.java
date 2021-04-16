package iua.edu.soa.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iua.edu.soa.business.exception.BusinessException;
import iua.edu.soa.model.Transaccion;
import iua.edu.soa.model.persistence.TransaccionRepository;

@Service
public class TransaccionBusiness implements ITransaccionBusiness {

	@Autowired
	private TransaccionRepository transaccionDAO;
	
	
	@Override
	public Transaccion add(Transaccion transaccion) throws BusinessException {	
		try {
			return transaccionDAO.save(transaccion);
		} catch (Exception e) {
			throw new BusinessException(e);
		}	
	}
	
}
