package ecom.domain.repositories;

import ecom.domain.model.Produto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface RepositorioProduto extends CrudRepository<Produto, Long> {

    public List<Produto> findAllByNome(String nome);

    public List<Produto> findAllByNomeContains(String nome);


}
