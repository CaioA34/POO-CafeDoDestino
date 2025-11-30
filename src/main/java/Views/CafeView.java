package Views;
import Models.Produto;
import java.util.List;
import java.util.Scanner;

public class CafeView {
    private Scanner scanner;
    public CafeView(){
        this.scanner = new Scanner(System.in);
    }
    public void exibirCardapio(List<Produto> produtos){
        System.out.println("\n--- MENU CAFÉ DO DESTINO ---");
        for(Produto p : produtos){
            System.out.println(p.getIdProduto() + ". " + p.getNome() + " | R$ " + p.getValor());
        }
        System.out.println("4. Finalizar Pedido Atual"); // Nova opção
        System.out.println("5. Ver Relatório do Caixa"); // Nova opção (Pág 8)
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }
    public int lerOpcao(){
        try{
            int opcao = scanner.nextInt();
            scanner.nextLine();
            return opcao;
        }
        catch (Exception ex){
            scanner.nextLine();
            return -1;
        }
    }
    public void exibirMensagem(String mensagem){
        System.out.println(mensagem);
    }
}
