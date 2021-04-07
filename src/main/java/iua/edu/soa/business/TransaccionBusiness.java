package iua.edu.soa.business;

import java.util.List;

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
	public List<Transaccion> listPaid(Long id_client) throws BusinessException {
		try {
			System.out.print(id_client);
			return transaccionDAO.findPaid(id_client);
			//return ventaDAO.findBy
		} catch (Exception e) {
			throw new BusinessException(e);
		}
		
	}
}
