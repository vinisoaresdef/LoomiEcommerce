package projetoLoomi.ecommerce.ecommerce.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projetoLoomi.ecommerce.ecommerce.domain.entity.Cliente;
import projetoLoomi.ecommerce.ecommerce.domain.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ClienteService {

    private ClienteRepository repository;

    public Cliente salvar(Cliente cliente) {

        //TODO: avaliar se já tem um contato cadastrado para um cliente diferente. (Regra de negócio)
        return repository.save(cliente);

    }

    public List<Cliente> listarTodos() {
        return repository.findAll();

    }

    public Optional<Cliente> buscarPorId(Long id) {
        return repository.findById(id);

    }

    public void deletar(Long id){
        repository.deleteById(id);

    }




}
