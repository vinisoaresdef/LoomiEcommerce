package projetoLoomi.ecommerce.ecommerce.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import projetoLoomi.ecommerce.ecommerce.domain.entity.Usuario;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRegistroDTO {

    private String nome;

    public UsuarioRegistroDTO (Usuario usuario){
        this.nome = usuario.getNome();
    }

    public Usuario convertToUser() {
        Usuario usuario = new Usuario();
        usuario.setNome(this.nome);
        return usuario;
    }

}
