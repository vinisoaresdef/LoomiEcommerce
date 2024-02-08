package projetoLoomi.ecommerce.ecommerce.api.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import projetoLoomi.ecommerce.ecommerce.api.request.ClienteRequest;
import projetoLoomi.ecommerce.ecommerce.api.response.ClienteResponse;
import projetoLoomi.ecommerce.ecommerce.domain.entity.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ClienteMapper {

    private final ModelMapper mapper;

    public Cliente toCliente(ClienteRequest request) {
        return mapper.map(request, Cliente.class);

    }

    public ClienteResponse toClienteResponse(Cliente cliente) {
        return mapper.map(cliente, ClienteResponse.class);
    }

    // public static Cliente toCliente(ClienteRequest request){
    //    Cliente cliente = new Cliente();
    //   cliente.setNomeCompleto(request.getNomeCompleto());
    //  cliente.setContato(request.getContato());
    // cliente.setEndereco(request.getEndereco());
    //cliente.setStatus(request.getStatus());
    //return cliente;
    // }

    //public static ClienteResponse toClienteResponse(Cliente cliente){
    //   ClienteResponse response = new ClienteResponse();
    //    response.setCliente_id(cliente.getCliente_id());
    //     response.setNomeCompleto(cliente.getNomeCompleto());
    //  response.setContato(cliente.getContato());
    //   response.setEndereco(cliente.getEndereco());
    //    response.setStatus(cliente.getStatus());
    //     return response;
    //  }

    public List<ClienteResponse> toClienteResponseList(List<Cliente> clientes) {
        return clientes.stream()
                .map(this::toClienteResponse)
                .collect(Collectors.toList());
    }


    //public static List<ClienteResponse> toClienteResponseList(List<Cliente> clientes) {
    //   List<ClienteResponse> responses = new ArrayList<>();
    //  for (Cliente cliente : clientes) {
    //     responses.add(toClienteResponse(cliente));
    // }
    // return responses;
    // }

}
