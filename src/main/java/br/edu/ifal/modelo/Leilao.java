package br.edu.ifal.modelo;

import java.util.ArrayList;
import java.util.List;

public class Leilao {

    private Produto produto;
    private double valorMinimo;
    private List<Cliente> clientes;
    private List<Lance> lances;

    public Leilao(Produto produto, double valorMinimo) {
        this.produto = produto;
        this.valorMinimo = valorMinimo;
        this.clientes = new ArrayList<>();
        this.lances = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public void adicionarLance(Lance lance) {
        this.lances.add(lance);
    }

    public Produto getProduto() {
        return produto;
    }

    public double getValorMinimo() {
        return valorMinimo;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Lance> getLances() {
        return lances;
    }

}