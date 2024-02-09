package projetoLoomi.ecommerce.ecommerce.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetoLoomi.ecommerce.ecommerce.api.mapper.PedidoMapper;
import projetoLoomi.ecommerce.ecommerce.api.request.PedidoRequest;
import projetoLoomi.ecommerce.ecommerce.api.response.PedidoResponse;
import projetoLoomi.ecommerce.ecommerce.domain.entity.Pedido;
import projetoLoomi.ecommerce.ecommerce.domain.service.PedidoService;

import java.security.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService service;

    private final PedidoMapper mapper;

    @PostMapping("/salvar")
    public ResponseEntity<PedidoResponse> salvar(@Valid @RequestBody PedidoRequest request) {
        Pedido pedido = mapper.toPedido(request);
        Pedido pedidoSalvo = service.salvar(pedido);
        PedidoResponse pedidoResponse = mapper.toPedidoResponse(pedidoSalvo);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoResponse);
    }

    @GetMapping("/listarTodos")
    public ResponseEntity<List<PedidoResponse>> listarTodos(){
        List<Pedido> pedidos = service.listarTodos();
        List<PedidoResponse> pedidoResponses = mapper.toPedidoResponseList(pedidos);
        return ResponseEntity.status(HttpStatus.OK).body(pedidoResponses);
    }

    @PutMapping("/atualizar/{pedido_id}")
    public ResponseEntity<PedidoResponse> atualizar(@PathVariable Long pedido_id, @RequestBody PedidoRequest request) {
        Pedido pedido = mapper.toPedido(request);
        Pedido pedidoAtualizado = service.atualizar(pedido_id, pedido);
        PedidoResponse pedidoResponse = mapper.toPedidoResponse(pedidoAtualizado);
        return ResponseEntity.status(HttpStatus.OK).body(pedidoResponse);
    }

    @GetMapping("/{pedido_id}")
    public ResponseEntity<PedidoResponse> buscarPorId(@PathVariable Long pedido_id){
        Optional<Pedido> optPedido = service.buscarPorId(pedido_id);
        if(optPedido.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toPedidoResponse(optPedido.get()));
    }

    @DeleteMapping("/deletar/{pedido_id}")
    public ResponseEntity<Void> deletar(@PathVariable Long pedido_id) {
        boolean excluido = service.deletar(pedido_id);
        if (excluido) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/cliente/{nomeCompleto}")
    public ResponseEntity<List<Pedido>> getPedidosByCliente(@PathVariable String nomeCompleto) {
        List<Pedido> pedidos = service.listarPedidosCliente(nomeCompleto);
        return ResponseEntity.ok(pedidos);
    }


    @GetMapping("/data")
    public ResponseEntity<List<Pedido>> getPedidosEntreDatas(@RequestParam Timestamp dataInicio, @RequestParam Timestamp dataFim) {
        List<Pedido> pedidos = service.listarPedidosEntreDatas(dataInicio, dataFim);
        return ResponseEntity.ok(pedidos);
    }

}
