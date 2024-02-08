package projetoLoomi.ecommerce.ecommerce.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.security.Timestamp;

@Table(name = "produtos")
@Entity(name = "produtos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long produto_id;
    @Column(name = "nome_produto")
    private String nomeProduto;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "preco")
    private int preco;
    @Column(name = "qtd_estoque")
    private int qtdEstoque;
    @Column(name = "data_criacao")
    private String dataCriacao;
    @Column(name = "data_atualizacao")
    private String dataAtualizacao;

}
