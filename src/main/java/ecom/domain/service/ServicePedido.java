package ecom.domain.service;

import ecom.domain.enums.EnumPedidoStatus;
import ecom.domain.model.Pedido;
import ecom.domain.model.PedidoItem;
import ecom.domain.model.Produto;
import ecom.domain.repositories.RepositorioPedido;
import ecom.domain.repositories.RepositorioPedidoItem;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;


@Service
public class ServicePedido implements IServicePedido {

    private RepositorioPedido repositorioPedido;
    private RepositorioPedidoItem repositorioPedidoItem;

    @Inject
    public ServicePedido(RepositorioPedido repositorioPedido, RepositorioPedidoItem repositorioPedidoItem) {
        this.repositorioPedido = repositorioPedido;
        this.repositorioPedidoItem = repositorioPedidoItem;
    }

    @Override
    public List<Pedido> buscarTodosPorNomeCliente(String nome) {
        return repositorioPedido.findAllByNomeCliente(nome);
    }

    @Override
    public void adicionarProduto(Pedido pedido, Produto produto, double valorUnitario, double quantidade) {
        pedido.getItens().add(new PedidoItem(produto, valorUnitario, quantidade));
    }

    @Override
    public void fecharPedido(Pedido pedido) {
        pedido.setStatus(EnumPedidoStatus.Fechado);
    }

    @Override
    public void gravaPedido(Pedido pedido) {
        repositorioPedido.save(pedido);
        repositorioPedidoItem.save(pedido.getItens());
    }

    @Override
    public Pedido obterPeloId(Long id) {
        return repositorioPedido.findOne(id);
    }

}
