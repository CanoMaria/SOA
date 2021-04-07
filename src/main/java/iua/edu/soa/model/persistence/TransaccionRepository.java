package iua.edu.soa.model.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import iua.edu.soa.model.Transaccion;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {

	@Query(value = "select * from transaccion t " + 
			"inner join cliente c on t.id_cliente =c.id_cliente " + 
			"inner join factura f on t.factura_id_factura=f.id_factura " + 
			"where c.id_cliente = :id_client and f.estado=1 ", nativeQuery = true)
	public  List<Transaccion> findPaid(@Param("id_client") long id_client);
	

}
