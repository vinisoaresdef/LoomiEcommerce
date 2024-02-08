package projetoLoomi.ecommerce.ecommerce.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projetoLoomi.ecommerce.ecommerce.domain.entity.Cliente;
import projetoLoomi.ecommerce.ecommerce.domain.repository.ClienteRepository;
import projetoLoomi.ecommerce.ecommerce.exception.BusinessException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public Cliente salvar(Cliente cliente) {

        //TODO: avaliar se já tem um usuario cadastrado para um cliente diferente. (Regra de negócio)

     //   boolean existeUsuario = false;
     //   Optional<Cliente> optCliente = repository.findByUserId(cliente.getUsuario().getCliente());

     //    if(optCliente.isPresent()) {
     //       if(!optCliente.get().getCliente_id().equals(cliente.getCliente_id()));{
     //           existeUsuario = true;
     //       }
     //   }
     //   if(existeUsuario){
     //       throw new BusinessException("Usuario já existe");
     //   }

        return repository.save(cliente);

    }

    public List<Cliente> listarTodos() {
        return repository.findAll();

    }

    public Optional<Cliente> buscarPorId(Long id) {
        return repository.findById(id);

    }

    public boolean deletar(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true; // Cliente excluído com sucesso
        } else {
            return false; // Cliente não encontrado para exclusão
        }
    }


    public Cliente atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteExistente = repository.findById(id);
        if (clienteExistente.isPresent()) {
            Cliente clienteAtualizado = clienteExistente.get();
            clienteAtualizado.setNomeCompleto(cliente.getNomeCompleto());
            clienteAtualizado.setEndereco(cliente.getEndereco());
            clienteAtualizado.setContato(cliente.getContato());
            clienteAtualizado.setUsuario(cliente.getUsuario());
            return repository.save(clienteAtualizado);
        } else {
            return null; // Cliente não encontrado para atualização
        }
    }




}
