package iua.edu.soa.model.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import iua.edu.soa.model.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Long> {

	@Query(value = "select * from factura where cliente_id_cliente= :id", nativeQuery = true)
	Optional<Factura> findByClientId(@Param("id") Long id_cliente);
	
	@Query(value = "select * from factura where cliente_id_cliente= :id and estado=1;", nativeQuery = true)
	Optional<Factura> findPaidsByClientId(@Param("id") Long id_cliente);


}
