package projetoLoomi.ecommerce.ecommerce.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projetoLoomi.ecommerce.ecommerce.domain.entity.Cliente;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
