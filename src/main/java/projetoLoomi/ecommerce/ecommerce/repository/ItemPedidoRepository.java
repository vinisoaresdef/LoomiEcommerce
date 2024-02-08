package projetoLoomi.ecommerce.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projetoLoomi.ecommerce.ecommerce.domain.Pedido;

public interface ItemPedidoRepository extends JpaRepository<Pedido, Long> {
}
