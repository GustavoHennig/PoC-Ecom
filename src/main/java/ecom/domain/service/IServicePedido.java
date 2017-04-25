package ecom.domain.service;

import ecom.domain.model.Pedido;
import ecom.domain.model.Produto;

import java.util.List;

public interface IServicePedido
{
	List<Pedido> buscarTodosPorNomeCliente(String nome);

	void adicionarProduto(Pedido pedido, Produto produto, double valorUnitario, double quantidade);

	void fecharPedido(Pedido pedido);

	void gravaPedido(Pedido pedido);

    Pedido obterPeloId(Long id);
}
