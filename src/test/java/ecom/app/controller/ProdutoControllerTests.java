package ecom.app.controller;

import ecom.domain.model.Produto;
import ecom.domain.service.ServiceProduto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

/**
 * Created by @GustavoHennig on 2017-04-25.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProdutoControllerTests {

    @Autowired
    private ProdutoController produtoController;

    @Test
    public void testCriarProduto() {

        Produto produto = new Produto();
        produto.setNome("Chocolate 1");
        produto.setValorVenda(2);

        produtoController.criaProduto(produto);

        List<Produto> produtos = produtoController.buscarTodosContendoNome("Chocolate");

        assertThat(produtos).extracting(Produto::getNome).containsExactly(produto.getNome());
    }

}



