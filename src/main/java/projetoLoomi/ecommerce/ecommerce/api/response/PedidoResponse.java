package projetoLoomi.ecommerce.ecommerce.api.response;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import projetoLoomi.ecommerce.ecommerce.domain.entity.Cliente;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoResponse {

    private Long pedido_id;
    private Cliente cliente;
    private String status;   //Isso aqui não deve ser uma String, deve ser trabalhado como ENUM ainda.
    private String dataPedido;
    private int totalPedido;


}
