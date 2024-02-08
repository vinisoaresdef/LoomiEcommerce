package projetoLoomi.ecommerce.ecommerce.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.w3c.dom.Text;

@Table(name = "clientes")
@Entity(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cliente_id;
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @Column(name = "nome_completo")
    private String nomeCompleto;
    @Column(name = "contato")
    private String contato;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "status")
    private String status;
    @Column(name = "data_criacao")
    private String dataCriacao;        //TODO: Corrigir para TimeStamp e avaliar no banco.
    @Column(name = "data_atualizacao")
    private String dataAtualizacao;    //TODO: Corrigir para TimeStamp e avaliar no banco.

}
