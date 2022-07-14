package Produto;

import java.util.Date;
import java.util.List;

public class RegistroDePagamento {
    private List<Produto>listaProduto;
    private Date dataDaCompra;
    private Cliente cliente;

    public RegistroDePagamento(List<Produto> listaProduto, Date dataDaCompra, Cliente cliente) {
        this.listaProduto = listaProduto;
        this.dataDaCompra = dataDaCompra;
        this.cliente = cliente;
    }

    public RegistroDePagamento() {
    }

    public List<Produto> getListaProduto() {
        return listaProduto;
    }

    public Date getDataDaCompra() {
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
