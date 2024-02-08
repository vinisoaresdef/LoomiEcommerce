package projetoLoomi.ecommerce.ecommerce.api.response;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoResponse {
    private Long produto_id;
    private String nomeProduto;
    private String descricao;
    private int preco;
    private int qtdEstoque;
    private String dataCriacao;
    private String dataAtualizacao;


}
