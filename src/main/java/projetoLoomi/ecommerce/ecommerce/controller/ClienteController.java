package projetoLoomi.ecommerce.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetoLoomi.ecommerce.ecommerce.domain.entity.Cliente;
import projetoLoomi.ecommerce.ecommerce.domain.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository ClienteRepository;
      //Evitar usar Repository dentro do controller

    @GetMapping("listarTodos")
    public List<Cliente> getAll(){

        List<Cliente> ClienteList = ClienteRepository.findAll();
        return ClienteList;
    }

    @PostMapping("criarNovoCliente")
    public ResponseEntity<String> criarCliente(@RequestBody Cliente cliente) {
        ClienteRepository.save(cliente);
        return ResponseEntity.ok("Cliente criado com sucesso!");
    }

    @PutMapping("atualizarCliente/{id}")
    public ResponseEntity<String> atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        Optional<Cliente> clienteOptional = ClienteRepository.findById(id);
        if (clienteOptional.isPresent()) {
            //cliente.setId(id);
            ClienteRepository.save(cliente);
            return ResponseEntity.ok("Cliente atualizado com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("excluirCliente/{id}")
    public ResponseEntity<String> excluirCliente(@PathVariable Long id) {
        Optional<Cliente> clienteOptional = ClienteRepository.findById(id);
        if (clienteOptional.isPresent()) {
            ClienteRepository.deleteById(id);
            return ResponseEntity.ok("Cliente excluído com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
