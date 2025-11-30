package Models;

public class Latte extends Bebida {

    public Latte(Integer idProduto) {
        super("Latte", 7.00, idProduto);
    }

    @Override
    public void preparar() {
        System.out.println("Vaporizando leite e adicionando ao espresso - preparando um Latte!");
    }
}