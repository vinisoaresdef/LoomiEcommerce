package projetoLoomi.ecommerce.ecommerce.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projetoLoomi.ecommerce.ecommerce.domain.entity.Cliente;


import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

    //regra para validar se já não existe um Cliente com o mesmo usuário.


    //Optional<Cliente> findByUserId(Cliente cliente_id);

}
