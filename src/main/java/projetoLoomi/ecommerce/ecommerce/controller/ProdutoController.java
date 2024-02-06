package projetoLoomi.ecommerce.ecommerce.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @GetMapping
    public ResponseEntity getAllProducts(){
        return ResponseEntity.ok("deu ok");
    }

    @PostMapping
    public ResponseEntity createProduct (@RequestBody String produto){
        return ResponseEntity.ok("Produto criado: " +  produto);
    }

}
