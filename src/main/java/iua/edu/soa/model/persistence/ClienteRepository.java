package iua.edu.soa.model.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import iua.edu.soa.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
