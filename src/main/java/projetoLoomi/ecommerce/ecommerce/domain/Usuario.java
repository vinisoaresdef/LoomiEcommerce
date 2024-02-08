package projetoLoomi.ecommerce.ecommerce.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.Timestamp;

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
    @OneToOne
    private Cliente cliente;
    @Column(name = "nome")
    private String nome;
    @Column(name = "data_criacao")
    private String dataCriacao;
    @Column(name = "data_Atualizacao")
    private String dataAtualizacao;

}