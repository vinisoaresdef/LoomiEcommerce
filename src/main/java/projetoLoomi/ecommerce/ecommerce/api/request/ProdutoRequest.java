package projetoLoomi.ecommerce.ecommerce.api.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoRequest {
    private Long produto_id;
    @NotBlank(message = "Produto precisa ter nome")
    private String nomeProduto;
    @NotBlank(message = "Produto precisa ter descrição")
    private String descricao;
    @NotNull
    private int preco;
    private int qtdEstoque;
    private String dataCriacao;
    private String dataAtualizacao;
}
