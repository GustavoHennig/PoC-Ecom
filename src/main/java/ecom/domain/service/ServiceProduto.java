package ecom.domain.service;

import ecom.domain.model.Produto;
import ecom.domain.repositories.RepositorioProduto;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;


@Service
public class ServiceProduto implements IServiceProduto {

    private RepositorioProduto repositorioProduto;

    @Inject
    public ServiceProduto(RepositorioProduto repositorioProduto) {
        this.repositorioProduto = repositorioProduto;
    }

    @Override
    public List<Produto> buscarTodosPorNome(String nome) {
        return repositorioProduto.findAllByNome(nome);
    }

    @Override
    public List<Produto> buscarTodosContendoNome(String nomeContem) {
        return repositorioProduto.findAllByNomeContains(nomeContem);
    }

    @Override
    public void gravarProduto(Produto produto) {
        repositorioProduto.save(produto);
    }

    @Override
    public void apagarProduto(Produto produto) {
        repositorioProduto.delete(produto);

    }
}