package projetoLoomi.ecommerce.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projetoLoomi.ecommerce.ecommerce.model.Cliente;
import projetoLoomi.ecommerce.ecommerce.repository.ClienteRepository;

import java.util.List;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @GetMapping
    public List<Cliente> getAll(){

        List<Cliente> ClienteList = repository.findAll();
        return ClienteList;
    }
}
