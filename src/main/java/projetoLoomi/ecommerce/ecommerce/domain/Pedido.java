package projetoLoomi.ecommerce.ecommerce.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.Timestamp;

@Entity(name = "pedidos")
@Table(name = "pedidos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pedido_id;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @Column(name = "status")
    private StatusPedido status;
    @Column(name  = "data_pedido")
    private String dataPedido;
    @Column(name = "total_pedido")
    private int totalPedido;

}
enum StatusPedido {
    RECEBIDO,
    EM_PREPARACAO,
    DESPACHADO,
    ENTREGUE
}