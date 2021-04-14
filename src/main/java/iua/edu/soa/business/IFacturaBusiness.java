package iua.edu.soa.business;


import iua.edu.soa.business.exception.BusinessException;
import iua.edu.soa.business.exception.NotFoundException;
import iua.edu.soa.model.Factura;

public interface IFacturaBusiness {

	public Factura load(Long id_cliente) throws NotFoundException, BusinessException;
	public Factura add(Factura factura) throws BusinessException;
	public Factura loadPaid(Long id_cliente) throws NotFoundException, BusinessException;

}
