package projetoLoomi.ecommerce.ecommerce.api.mapper;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import projetoLoomi.ecommerce.ecommerce.api.request.ProdutoRequest;
import projetoLoomi.ecommerce.ecommerce.api.response.ProdutoResponse;
import projetoLoomi.ecommerce.ecommerce.domain.entity.Produto;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProdutoMapper {

    private final ModelMapper mapper;

    public Produto toProduto(ProdutoRequest request) {
        return mapper.map(request, Produto.class);

    }

    public ProdutoResponse toProdutoResponse(Produto produto) {
        return mapper.map(produto, ProdutoResponse.class);
    }

    public List<ProdutoResponse> toProdutoResponseList(List<Produto> produtos) {
        return produtos.stream()
                .map(this::toProdutoResponse)
                .collect(Collectors.toList());
    }

}
