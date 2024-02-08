package projetoLoomi.ecommerce.ecommerce.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "usuarios")
@Entity(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuario_id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "email")
    private String email;
    @Column(name = "senha")
    private String senha;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "data_criacao")
    private String dataCriacao;          //TODO: Corrigir para TimeStamp e avaliar no banco.
    @Column(name = "data_Atualizacao")
    private String dataAtualizacao;      //TODO: Corrigir para TimeStamp e avaliar no banco.


}

enum tipo {
    ADMIN,
    CLIENTE
};