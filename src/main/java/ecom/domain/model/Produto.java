package ecom.domain.model;

import javax.persistence.*;

/**
 * Created by @GustavoHennig on 2017-04-19.
 */

@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private double valorVenda;

    public Produto() {

    }

    public Produto(String nome, double valorVenda) {
        this.nome = nome;
        this.valorVenda = valorVenda;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }
}
