package projetoLoomi.ecommerce.ecommerce.api.controller;

import io.swagger.models.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetoLoomi.ecommerce.ecommerce.api.mapper.ClienteMapper;
import projetoLoomi.ecommerce.ecommerce.api.request.ClienteRequest;
import projetoLoomi.ecommerce.ecommerce.api.response.ClienteResponse;
import projetoLoomi.ecommerce.ecommerce.domain.entity.Cliente;
import projetoLoomi.ecommerce.ecommerce.domain.service.ClienteService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cliente")
public class ClienteController {

   private final ClienteService service;
      //Evitar usar Repository dentro do controller, por isso usei o ClienteService

    private final ClienteMapper mapper;

    @PostMapping("/salvar")
    public ResponseEntity<ClienteResponse> salvar(@Valid @RequestBody ClienteRequest request) {
        Cliente cliente = mapper.toCliente(request);
        Cliente clienteSalvo = service.salvar(cliente);
        ClienteResponse clienteResponse = mapper.toClienteResponse(clienteSalvo);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteResponse);
    }

    @GetMapping("/listarTodos")
    public ResponseEntity<List<ClienteResponse>> listarTodos(){
        List<Cliente> clientes = service.listarTodos();
        List<ClienteResponse> clienteResponses = mapper.toClienteResponseList(clientes);
        return ResponseEntity.status(HttpStatus.OK).body(clienteResponses);
    }

    @PutMapping("/atualizar/{cliente_id}")
    public ResponseEntity<ClienteResponse> atualizar(@PathVariable Long cliente_id, @RequestBody ClienteRequest request) {
        Cliente cliente = mapper.toCliente(request);
        Cliente clienteSalvo = service.atualizar(cliente_id, cliente);
        ClienteResponse clienteResponse = mapper.toClienteResponse(clienteSalvo);
        return ResponseEntity.status(HttpStatus.OK).body(clienteResponse);
    }

    @GetMapping("/{cliente_id}")
    public ResponseEntity<ClienteResponse> buscarPorId(@PathVariable Long cliente_id){
        Optional<Cliente> optCliente = service.buscarPorId(cliente_id);
        if(optCliente.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toClienteResponse(optCliente.get()));
    }

    @DeleteMapping("/deletar/{cliente_id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean excluido = service.deletar(id);
        if (excluido) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
