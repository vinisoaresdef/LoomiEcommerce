package projetoLoomi.ecommerce.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.security.Timestamp;

@Table(name = "clientes")
@Entity(name = "clientes")
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_ID")
    private Usuario usuario;

    private String nomeCompleto;
    private String contato;
    private String endereco;
    private Boolean status;
    private Timestamp dataCriacao;
    private Timestamp dataAtualizacao;

}