package projetoLoomi.ecommerce.ecommerce.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "itens")
@Table(name = "itens")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long item_id;
    @ManyToOne
    private Pedido pedido;
    @ManyToOne
    private Produto produto;
    @Column(name = "quantidade")
    private int quantidade;
    @Column(name = "preco_por_unidade")
    private float precoPorUnidade;
    @Column(name = "subtotal")
    private float subtotal;

}
