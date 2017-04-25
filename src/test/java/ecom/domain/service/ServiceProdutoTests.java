package ecom.domain.service;

import ecom.domain.model.Pedido;
import ecom.domain.model.Produto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

/**
 * Created by gusth on 20/04/2017.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class ServiceProdutoTests {

    @Autowired
    private ServiceProduto produtosService;

    @Test
    public void testCriarNovoProduto() {

        Produto produto = new Produto();
        produto.setNome("Chocolate");
        produto.setValorVenda(2);

        produtosService.gravarProduto(produto);

        List<Produto> produtos = produtosService.buscarTodosPorNome(produto.getNome());

        assertThat(produtos).extracting(Produto::getNome).containsExactly(produto.getNome());
    }

    @Test
    public void testAtualizarProdutoAlterandoPreco() {

        //Cria produto para atualizar em seguida
        Produto produto = new Produto();
        produto.setNome("Chocolate");
        produto.setValorVenda(2);

        produtosService.gravarProduto(produto);

        List<Produto> produtos = produtosService.buscarTodosPorNome(produto.getNome());

        assertThat(produtos).extracting("nome", "valorVenda").contains(
                tuple(produto.getNome(), produto.getValorVenda()));

        //Atualiza produto
        produto = produtos.get(0); //Não obrigatório, mas apenas assegura a utilização de nova instância
        produto.setValorVenda(3);
        produtosService.gravarProduto(produto);


        produtos = produtosService.buscarTodosPorNome(produto.getNome());

        assertThat(produtos).extracting("nome", "valorVenda").contains(
                tuple(produto.getNome(), produto.getValorVenda()));

    }


    @Test
    public void testApagarProduto() {

        //Cria produto para apagar em seguida
        Produto produto = new Produto();
        produto.setNome("Chocolate");
        produto.setValorVenda(2);

        produtosService.gravarProduto(produto);

        List<Produto> produtos = produtosService.buscarTodosPorNome(produto.getNome());

        assertThat(produtos).extracting(Produto::getNome).containsExactly(produto.getNome());

        produtosService.apagarProduto(produto);

        produtos = produtosService.buscarTodosPorNome(produto.getNome());

        assertThat(produtos).isEmpty();

    }


    @Test
    public void testBuscarTodosContendoNome() {

        //Cria produto para apagar em seguida

        produtosService.gravarProduto(new Produto("Chocolate Branco", 2));
        produtosService.gravarProduto(new Produto("Chocolate Amargo", 3));

        String conteudoBuscar = "Branco";
        String nomeProdutoEsperado = "Chocolate Branco";

        List<Produto> produtos = produtosService.buscarTodosContendoNome(conteudoBuscar);

        assertThat(produtos).extracting(Produto::getNome).containsExactly(nomeProdutoEsperado);


    }

}



