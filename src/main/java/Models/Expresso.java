package Models;
public class Expresso extends Bebida{
    public Expresso(Integer idProduto){
        super("Expresso", 5.00, idProduto);
    }
    @Override
    public void preparar(){
        System.out.println("Extraindo um expresso forte e aromático!");
    }
}
