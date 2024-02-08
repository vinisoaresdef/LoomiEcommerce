package projetoLoomi.ecommerce.ecommerce.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projetoLoomi.ecommerce.ecommerce.domain.entity.Produto;
import projetoLoomi.ecommerce.ecommerce.domain.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    public List<Produto> listarTodos(){
        return repository.findAll();
    }

    public Optional<Produto> buscarPorId(Long id) {
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

    public Produto atualizar(Long id, Produto produto) {
        Optional<Produto> produtoExistente = repository.findById(id);
        if(produtoExistente.isPresent()) {
            Produto produtoAtualizado = produtoExistente.get();
            produtoAtualizado.setNomeProduto(produto.getNomeProduto());
            produtoAtualizado.setDataAtualizacao(produto.getDataAtualizacao());
            produtoAtualizado.setDescricao(produto.getDescricao());
            produtoAtualizado.setPreco(produto.getPreco());
            produtoAtualizado.setQtdEstoque(produto.getQtdEstoque());
            return repository.save(produtoAtualizado);
        } else {
            return null;
        }
    }



}
