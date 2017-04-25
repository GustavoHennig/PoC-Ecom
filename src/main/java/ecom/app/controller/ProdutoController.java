package ecom.app.controller;

import ecom.domain.model.Produto;
import ecom.domain.service.IServiceProduto;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by @GustavoHennig on 2017-04-24.
 * Poderia existir outr
 */


@RestController
public class ProdutoController {

    private IServiceProduto serviceProduto;

    @Inject
    public ProdutoController(IServiceProduto serviceProduto) {
        this.serviceProduto = serviceProduto;
    }

    @RequestMapping(value = "/produto", method = RequestMethod.POST)
    public Produto criaProduto(@RequestBody Produto produto) {
        serviceProduto.gravarProduto(produto);
        return produto;
    }

    @RequestMapping(value = "/produto", method = RequestMethod.GET)
    public List<Produto> buscarTodosContendoNome(@RequestParam(value = "nome", defaultValue = "") String nome) {

        return serviceProduto.buscarTodosContendoNome(nome);
    }
}
