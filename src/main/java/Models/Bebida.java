package Models;
public abstract class Bebida extends Produto{
    public Bebida(String nome, Double valor, Integer idProduto){
        super(nome, valor, idProduto);
    }
    public abstract void preparar();
}
