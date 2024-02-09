package projetoLoomi.ecommerce.ecommerce.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projetoLoomi.ecommerce.ecommerce.domain.entity.Pedido;

import java.security.Timestamp;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByCliente_NomeCompleto(String nomeCompleto);

    List<Pedido> findByDataPedidoBetween(Timestamp dataInicio, Timestamp dataFim);



}
