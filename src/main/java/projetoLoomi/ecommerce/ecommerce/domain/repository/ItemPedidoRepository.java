package projetoLoomi.ecommerce.ecommerce.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projetoLoomi.ecommerce.ecommerce.domain.entity.Pedido;
@Repository
public interface ItemPedidoRepository extends JpaRepository<Pedido, Long> {
}
