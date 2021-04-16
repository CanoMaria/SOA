package iua.edu.soa.model.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import iua.edu.soa.model.Transaccion;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {

}
