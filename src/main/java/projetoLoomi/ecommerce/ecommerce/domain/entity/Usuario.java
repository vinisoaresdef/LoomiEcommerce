package projetoLoomi.ecommerce.ecommerce.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "usuarios")
@Entity(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "usuario_id")
public class Usuario implements UserDetails {
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
    private tipo tipo;
    @Column(name = "data_criacao")
    private String dataCriacao;          //TODO: Corrigir para TimeStamp e avaliar no banco.
    @Column(name = "data_Atualizacao")
    private String dataAtualizacao;      //TODO: Corrigir para TimeStamp e avaliar no banco.

    public Usuario(String nome, String senha, tipo tipo){
        this.nome = nome;
        this.senha = senha;
        this.tipo = tipo;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.tipo == tipo.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return nome;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}





enum tipo {
    ADMIN,
    CLIENTE
};