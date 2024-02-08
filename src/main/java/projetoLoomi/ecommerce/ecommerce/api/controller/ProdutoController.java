package projetoLoomi.ecommerce.ecommerce.api.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import projetoLoomi.ecommerce.ecommerce.api.mapper.ProdutoMapper;

import projetoLoomi.ecommerce.ecommerce.api.request.ProdutoRequest;

import projetoLoomi.ecommerce.ecommerce.api.response.ProdutoResponse;

import projetoLoomi.ecommerce.ecommerce.domain.entity.Produto;


import projetoLoomi.ecommerce.ecommerce.domain.service.ProdutoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;
    //Evitar usar Repository dentro do controller, por isso usei o ClienteService

    private final ProdutoMapper mapper;

    @PostMapping("/salvar")
    public ResponseEntity<ProdutoResponse> salvar(@Valid @RequestBody ProdutoRequest request) {
        Produto produto = mapper.toProduto(request);
        Produto produtoSalvo = service.salvar(produto);
        ProdutoResponse produtoResponse = mapper.toProdutoResponse(produtoSalvo);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoResponse);
    }

    @GetMapping("/listarTodos")
    public ResponseEntity<List<ProdutoResponse>> listarTodos(){
        List<Produto> produtos = service.listarTodos();
        List<ProdutoResponse> produtoResponses = mapper.toProdutoResponseList(produtos);
        return ResponseEntity.status(HttpStatus.OK).body(produtoResponses);
    }

    @PutMapping("/atualizar/{produto_id}")
    public ResponseEntity<ProdutoResponse> atualizar(@PathVariable Long produto_id, @RequestBody ProdutoRequest request) {
        Produto produto = mapper.toProduto(request);
        Produto produtoAtualizado = service.atualizar(produto_id, produto);
        ProdutoResponse produtoResponse = mapper.toProdutoResponse(produtoAtualizado);
        return ResponseEntity.status(HttpStatus.OK).body(produtoResponse);
    }

    @GetMapping("/{produto_id}")
    public ResponseEntity<ProdutoResponse> buscarPorId(@PathVariable Long produto_id){
        Optional<Produto> optProduto = service.buscarPorId(produto_id);
        if(optProduto.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toProdutoResponse(optProduto.get()));
    }

    @DeleteMapping("/deletar/{produto_id}")
    public ResponseEntity<Void> deletar(@PathVariable Long produto_id) {
        boolean excluido = service.deletar(produto_id);
        if (excluido) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }






}
