package ecom.domain.service;

import ecom.domain.enums.EnumPedidoStatus;
import ecom.domain.model.Pedido;
import ecom.domain.model.PedidoItem;
import ecom.domain.model.Produto;
import ecom.domain.repositories.RepositorioPedido;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.doesNotHave;

/**
 * Created by gusth on 20/04/2017.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class ServicePedidoTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ServicePedido pedidosService;


    @Autowired
    private ServiceProduto produtosService;


    @Before
    public void prepara() {
        produtosService.gravarProduto(new Produto("Adubo", 3.5));
    }


    @Test
    public void testBuscarTodosPorNomeCliente() {
        Pedido pedido = new Pedido("Nome do cliente");


        entityManager.persist(pedido);

        List<Pedido> findByNomeCliente = pedidosService.buscarTodosPorNomeCliente(pedido.getNomeCliente());

        assertThat(findByNomeCliente).extracting(Pedido::getNomeCliente).containsOnly(pedido.getNomeCliente());
    }

    @Test
    public void testCriaPedidoComUmItem() {
        Pedido pedido = new Pedido("Nome do cliente");


        List<Produto> produtos = produtosService.buscarTodosContendoNome("Adubo");

        assertThat(produtos).extracting(Produto::getNome).containsOnly("Adubo");

        Produto produto = produtos.get(0);

        double novoValor = produto.getValorVenda() + 1;

        pedidosService.adicionarProduto(pedido, produto, novoValor, 1);

        pedidosService.gravaPedido(pedido);


        List<Pedido> findByNomeCliente = pedidosService.buscarTodosPorNomeCliente(pedido.getNomeCliente());

        assertThat(findByNomeCliente).extracting(Pedido::getNomeCliente).containsOnly(pedido.getNomeCliente());

        for (Pedido ped : findByNomeCliente) {
            assertThat(ped.getItens()).extracting(PedidoItem::getValorUnitario).containsOnly(novoValor);
        }

    }


    @Test
    public void testFechaPedidoEVerificaStatus() {
        Pedido pedido = new Pedido("Nome do cliente");

        pedidosService.gravaPedido(pedido);


        List<Pedido> pedidos = pedidosService.buscarTodosPorNomeCliente(pedido.getNomeCliente());

        pedido = pedidos.get(0);

        pedidosService.fecharPedido(pedido);
        pedidosService.gravaPedido(pedido);

        pedidos = pedidosService.buscarTodosPorNomeCliente(pedido.getNomeCliente());
        pedido = pedidos.get(0);

        assertThat(pedidos).extracting(Pedido::getStatus).containsOnly(EnumPedidoStatus.Fechado);

    }

    @Test
    public void testAlteraPrecoPedidoItem() {

        //Inicializa o teste criando pedido com um item
        Pedido pedido = new Pedido("Nome do cliente");

        List<Produto> produtos = produtosService.buscarTodosContendoNome("Adubo");

        assertThat(produtos).extracting(Produto::getNome).containsOnly("Adubo");

        Produto produto = produtos.get(0);

        pedidosService.adicionarProduto(pedido, produto, produto.getValorVenda(), 1);
        pedidosService.gravaPedido(pedido);


        //Busca o pedido para atualizar o preço de um item

        List<Pedido> pedidos = pedidosService.buscarTodosPorNomeCliente(pedido.getNomeCliente());

        assertThat(pedidos).extracting(Pedido::getNomeCliente).containsOnly(pedido.getNomeCliente());

        PedidoItem pedItem = pedido.getItens().get(0);

        pedItem.setValorUnitario(10.1);

        pedidosService.gravaPedido(pedido);

        //Após gravar, busca novamente do banco para validar atualização do valor

        pedido = pedidosService.obterPeloId(pedido.getId());
        assertThat(pedido.getItens()).extracting(PedidoItem::getValorUnitario).containsOnly(10.1);

    }
}



