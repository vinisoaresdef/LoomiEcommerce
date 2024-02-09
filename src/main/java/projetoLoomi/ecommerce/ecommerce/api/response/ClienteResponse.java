package projetoLoomi.ecommerce.ecommerce.api.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import projetoLoomi.ecommerce.ecommerce.domain.entity.Usuario;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ClienteResponse {
    private Long cliente_id;
    private Usuario usuario;
    private String nomeCompleto;
    private String contato;
    private String endereco;
    private String status;
    private String dataCriacao;
    private String dataAtualizacao;
}
