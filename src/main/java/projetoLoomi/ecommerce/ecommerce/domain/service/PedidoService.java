package projetoLoomi.ecommerce.ecommerce.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projetoLoomi.ecommerce.ecommerce.domain.entity.Pedido;
import projetoLoomi.ecommerce.ecommerce.domain.repository.PedidoRepository;
import projetoLoomi.ecommerce.ecommerce.exception.NoClienteException;

import java.security.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public Pedido salvar(Pedido pedido) {

        if (pedido.getCliente() == null) { //FIXME: dando erro
            throw new NoClienteException("O pedido deve estar associado a um cliente.");
        }

        return repository.save(pedido);
    }

    public List<Pedido> listarTodos() {
        return repository.findAll();
    }

    public Optional<Pedido> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public boolean deletar(Long id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Pedido atualizar(Long id, Pedido pedido) {
        Optional<Pedido> pedidoExistente = repository.findById(id);
        if(pedidoExistente.isPresent()) {
            Pedido pedidoAtualizado = pedidoExistente.get();
            pedido.setTotalPedido(pedido.getTotalPedido());
            pedido.setCliente(pedido.getCliente());
            pedido.setStatus(pedido.getStatus());
            pedido.setDataPedido(pedido.getDataPedido());
            return repository.save(pedidoAtualizado);
        } else {
            return null;
        }
    }

    public List<Pedido> listarPedidosCliente(String nomeCompleto) {
        return repository.findByCliente_NomeCompleto(nomeCompleto);
    }

    public List<Pedido> listarPedidosEntreDatas(Timestamp dataInicio, Timestamp dataFim) {
        return repository.findByDataPedidoBetween(dataInicio, dataFim);
    }


}
