package projetoLoomi.ecommerce.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projetoLoomi.ecommerce.ecommerce.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
