package projetoLoomi.ecommerce.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projetoLoomi.ecommerce.ecommerce.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
