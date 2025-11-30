package Models;

public class Mocha extends Bebida {

    public Mocha(Integer idProduto) {
        super("Mocha", 8.50, idProduto);
    }

    @Override
    public void preparar() {
        System.out.println("Misturando café, leite vaporizado e chocolate - preparando um Mocha!");
    }
}