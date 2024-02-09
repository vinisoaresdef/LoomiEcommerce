package projetoLoomi.ecommerce.ecommerce.api.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import projetoLoomi.ecommerce.ecommerce.api.request.PedidoRequest;
import projetoLoomi.ecommerce.ecommerce.api.response.PedidoResponse;
import projetoLoomi.ecommerce.ecommerce.domain.entity.Pedido;

import java.security.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PedidoMapper {


    private final ModelMapper mapper;

    public Pedido toPedido(PedidoRequest request){
        return mapper.map(request, Pedido.class);
    }

    public PedidoResponse toPedidoResponse(Pedido pedido) {return mapper.map(pedido, PedidoResponse.class);}

    public List<PedidoResponse> toPedidoResponseList(List<Pedido> pedidos) {
        return pedidos.stream()
                .map(this::toPedidoResponse)
                .collect(Collectors.toList());
    }


}
