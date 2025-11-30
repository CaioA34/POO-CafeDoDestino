package Models;

import java.util.Date;
import java.util.List;

public class Pedido {
    private List<Produto> produtos;
    private Date dataPedido;
    private Cliente cliente; //Quem realizou o pedido;
    private Integer idPedido;
    private Double valorTotal;
    public Pedido(Cliente cliente, Date dataPedido){
        this.cliente = cliente;
        this.dataPedido = dataPedido;
    }
    public void AdicionarProduto(Produto item){
        this.produtos.add(item);
        this.valorTotal += item.getValor();
        System.out.println(item + " adicionado ao carrinho!");
    }
    public void exibirDados(){
        System.out.println("-- Comanda" + this.idPedido + " --");
        System.out.println("Data do Pedido: " + this.dataPedido);
        System.out.println("-- Lista de Produtos --");
        for(int i = 1; i<=this.produtos.size();i++ ){
            System.out.println(i + ". " + this.produtos.get(i).getNome() + "| Valor: " + this.produtos.get(i).getValor());
        }
    }
}
