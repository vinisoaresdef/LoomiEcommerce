package projetoLoomi.ecommerce.ecommerce.api.request;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import projetoLoomi.ecommerce.ecommerce.domain.entity.Usuario;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequest {
    private Long cliente_id;
    private Usuario usuario;
    @NotBlank(message = "Nome completo obrigatório")
    private String nomeCompleto;
    @NotBlank(message = "Contato obrigatório")
    private String contato;
    @NotBlank(message = "Endereço obrigatório")
    private String endereco;
    private String status;
    private String dataCriacao;
    private String dataAtualizacao;
}
