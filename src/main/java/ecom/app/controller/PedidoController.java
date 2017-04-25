package ecom.app.controller;

import ecom.domain.model.Pedido;
import ecom.domain.service.IServicePedido;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

/**
 * Created by @GustavoHennig on 2017-04-24.
 * Poderia existir outr
 */


@RestController
public class PedidoController {

    private IServicePedido servicePedido;

    @Inject
    public PedidoController(IServicePedido servicePedido) {
        this.servicePedido = servicePedido;
    }


    @RequestMapping(value = "/pedido", method = RequestMethod.GET)
    public Pedido obtemPeloId(@RequestParam(value = "id", defaultValue = "0") Long id) {
        return servicePedido.obterPeloId(id);
    }

    @RequestMapping(value = "/pedido", method = RequestMethod.POST)
    public Pedido criaPedido(@RequestBody Pedido pedido) {
        servicePedido.gravaPedido(pedido);
        return pedido;
    }

}
