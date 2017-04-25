package ecom.domain.service;

import ecom.domain.model.Produto;

import java.util.List;

public interface IServiceProduto {
    List<Produto> buscarTodosPorNome(String nome);

    List<Produto> buscarTodosContendoNome(String nomeContem);

    void gravarProduto(Produto produto);

    void apagarProduto(Produto produto);

}
