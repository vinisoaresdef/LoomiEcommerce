package projetoLoomi.ecommerce.ecommerce.model;


import jakarta.persistence.*;

import java.security.Timestamp;

@Table(name = "clientes")
@Entity(name = "clientes")
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
    private Boolean ativo;
    private Timestamp dataCriacao;
    private Timestamp dataAtualizacao;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
