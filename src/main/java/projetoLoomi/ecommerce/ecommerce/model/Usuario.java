package projetoLoomi.ecommerce.ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.security.Timestamp;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Timestamp dataCriacao;
    private Timestamp dataAtualizacao;

}