package Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private List<Produto> produtos = new ArrayList<>();
    private Date dataPedido;
    private Cliente cliente; //Quem realizou o pedido;
    private Integer idPedido;
    private Double valorTotal;
    public Pedido(Cliente cliente, Date dataPedido){
        this.cliente = cliente;
        this.dataPedido = dataPedido;
        this.produtos = new ArrayList<>();
        this.valorTotal = 0.0;
        this.idPedido = (int) (Math.random() * 1000);
    }
    public void AdicionarProduto(Produto item){
        this.produtos.add(item);
        this.valorTotal += item.getValor();
        System.out.println(item.getNome() + " adicionado ao carrinho!");
    }
    public void exibirDados(){
        System.out.println("-- Comanda " + this.idPedido + " --");
        System.out.println("Data: " + this.dataPedido);
        System.out.println("-- Itens do Pedido --");
        for(int i = 0; i<this.produtos.size();i++ ){
            Produto p = this.produtos.get(i);
            System.out.println((i + 1) + ". " + p.getNome() + "| Valor: " + p.getValor());
        }
        System.out.println("------------------------------");
        System.out.println("TOTAL: R$ " + String.format("%.2f", this.valorTotal));
        System.out.println("------------------------------");
    }

    public List<Produto> getProdutos() {
        return this.produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Date getDataPedido() {
        return this.dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getIdPedido() {
        return this.idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Double getValorTotal() {
        return this.valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
