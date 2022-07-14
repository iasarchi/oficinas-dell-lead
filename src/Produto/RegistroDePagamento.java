package Produto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class RegistroDePagamento {
    private List<Produto>listaProduto;
    private LocalDate dataDaCompra;
    private Cliente cliente;

    public RegistroDePagamento(List<Produto> listaProduto, LocalDate dataDaCompra, Cliente cliente) {
        this.listaProduto = listaProduto;
        this.dataDaCompra = dataDaCompra;
        this.cliente = cliente;
    }

    public RegistroDePagamento() {
    }

    public List<Produto> getListaProduto() {
        return listaProduto;
    }

    public LocalDate getDataDaCompra() {
        return dataDaCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        return "RegistroDePagamento{" +
                "listaProduto=" + listaProduto +
                ", dataDaCompra=" + dataDaCompra +
                ", cliente=" + cliente +
                '}';
    }
}
