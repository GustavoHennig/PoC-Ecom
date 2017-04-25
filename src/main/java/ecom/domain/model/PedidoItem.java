package ecom.domain.model;

import javax.persistence.*;

/**
 * Created by @GustavoHennig on 2017-04-20.
 */
@Entity
@Table(name = "pedido_item")
public class PedidoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(targetEntity = Produto.class)
    private Produto produto;
    private double valorUnitario;
    private double quantidade;

    public PedidoItem() {
    }

    public PedidoItem(Produto produto, double valorUnitario, double quantidade) {
        this.produto = produto;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }
}
