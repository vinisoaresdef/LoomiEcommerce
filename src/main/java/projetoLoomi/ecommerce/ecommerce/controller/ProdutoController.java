package projetoLoomi.ecommerce.ecommerce.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetoLoomi.ecommerce.ecommerce.domain.Produto;
import projetoLoomi.ecommerce.ecommerce.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("listarTodos")
    public ResponseEntity getAllProducts() {
        List<Produto> produtos = produtoRepository.findAll();
        return ResponseEntity.ok(produtos);
    }

    @PostMapping("cadastroProduto")
    public ResponseEntity createProduct(@RequestBody Produto produto) {
       Produto produtoSalvo = produtoRepository.save(produto);
        return ResponseEntity.ok("Produto criado: " + produtoSalvo);
    }

    @PutMapping("atualizarProduto/{id}")
    public ResponseEntity<Produto> updateProduct(@PathVariable Long id, @RequestBody Produto produto) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        if (produtoOptional.isPresent()) {
            Produto produtoExistente = produtoOptional.get();
            //produtoExistente.setNomeProduto(produto.getNomeProduto());
            //produtoExistente.setDescricao(produto.getDescricao());
            //produtoExistente.setPreco(produto.getPreco());
            //produtoExistente.setQtdEstoque(produto.getQtdEstoque());
            //produtoExistente.setDataAtualizacao(produto.getDataAtualizacao());
            Produto produtoAtualizado = produtoRepository.save(produtoExistente); // Atualizando o produto no banco de dados
            return ResponseEntity.ok(produtoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("deletarProduto/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        if (produtoOptional.isPresent()) {
            produtoRepository.deleteById(id);
            return ResponseEntity.ok("Produto excluído com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
