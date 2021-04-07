package iua.edu.soa.model.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import iua.edu.soa.model.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Long> {

}
