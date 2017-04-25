package ecom.domain.repositories;

import ecom.domain.model.Pedido;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface RepositorioPedido extends CrudRepository<Pedido, Long> {
    public Pedido findFirstById(Long id);

    public List<Pedido> findAllByNomeCliente(String nome);


}
