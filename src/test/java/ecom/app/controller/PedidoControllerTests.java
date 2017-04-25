package ecom.app.controller;

import ecom.domain.model.Pedido;
import ecom.domain.model.PedidoItem;
import ecom.domain.model.Produto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by @GustavoHennig on 2017-04-25.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class PedidoControllerTests {

    @Autowired
    private PedidoController pedidoController;

    @Test
    public void testCriarPedido() {

        Pedido pedido = new Pedido("Nome do cliente");


        pedidoController.criaPedido(pedido);


        Pedido pedidoObtido = pedidoController.obtemPeloId(pedido.getId());

        assertThat(pedido).isEqualTo(pedidoObtido);

    }

}



