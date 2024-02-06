package projetoLoomi.ecommerce.ecommerce.model;

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
    private Long id;

    private String nomeProduto;
    private String descricao;
    private float preco;
    private int qtdEstoque;
    private Timestamp dataCriacao;
    private Timestamp dataAtualizacao;

}
