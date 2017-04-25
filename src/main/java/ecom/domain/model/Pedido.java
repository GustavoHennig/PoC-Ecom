package ecom.domain.model;

import ecom.domain.enums.EnumPedidoStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by @GustavoHennig on 2017-04-20.
 */
@Entity
@Table(name = "pedido")
public class Pedido {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nomeCliente;

    @OneToMany(fetch = FetchType.EAGER, targetEntity = PedidoItem.class)
    private List<PedidoItem> itens;

    private EnumPedidoStatus status;

    public Pedido() {
        this(null);
    }

    public Pedido(String nomeCliente) {
        this.nomeCliente = nomeCliente;
        this.status = EnumPedidoStatus.Aberto;
        this.setItens(new ArrayList<PedidoItem>());
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public List<PedidoItem> getItens() {
        return itens;
    }

    public void setItens(List<PedidoItem> itens) {
        this.itens = itens;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public EnumPedidoStatus getStatus() {
        return status;
    }

    public void setStatus(EnumPedidoStatus status) {
        this.status = status;
    }
}
