package iua.edu.soa.business;

import java.util.List;

import iua.edu.soa.business.exception.BusinessException;
import iua.edu.soa.business.exception.NotFoundException;
import iua.edu.soa.model.Transaccion;


public interface ITransaccionBusiness {

	public Transaccion add(Transaccion transaccion) throws BusinessException;

}
