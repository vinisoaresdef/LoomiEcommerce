package projetoLoomi.ecommerce.ecommerce.api.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import projetoLoomi.ecommerce.ecommerce.domain.entity.Cliente;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoRequest {

    private Long pedido_id;
    //@NotBlank(message = "É necessário que exista um cliente atrelado ao pedido")
    private Cliente cliente;
    @NotBlank(message = "É necessário que haja um status para o pedido")
    private String status;   //Isso aqui não deve ser uma String, deve ser trabalhado como ENUM ainda.
    private String dataPedido;
    private int totalPedido;

}

