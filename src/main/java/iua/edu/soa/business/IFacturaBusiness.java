package iua.edu.soa.business;


import iua.edu.soa.business.exception.BusinessException;
import iua.edu.soa.business.exception.NotFoundException;
import iua.edu.soa.model.Factura;

public interface IFacturaBusiness {

	public Factura add(Factura factura) throws BusinessException;
	public Factura load(Long id_cliente) throws NotFoundException, BusinessException;
	public Factura loadPaid(Long id_cliente) throws NotFoundException, BusinessException;
	public Factura loadById(Long id_factura) throws NotFoundException, BusinessException;
	public Factura changeStatus(Long id_factura) throws BusinessException, NotFoundException;

}
