package projetoLoomi.ecommerce.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projetoLoomi.ecommerce.ecommerce.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
