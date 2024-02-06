package projetoLoomi.ecommerce.ecommerce.model;

import java.security.Timestamp;

public class Pedido {


    private Long id;
    private Long idCliente;

    private StatusPedido status;
    private Timestamp dataPedido;
    private float totalPedido;


}
enum StatusPedido {
    RECEBIDO,
    EM_PREPARACAO,
    DESPACHADO,
    ENTREGUE
}