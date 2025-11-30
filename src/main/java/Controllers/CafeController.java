package Controllers;
import Models.*;
import Views.CafeView;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CafeController {
    private List<Produto> cardapio;
    private List<Pedido> historicoVendas;
    private Pedido pedidoAtual;
    private CafeView view;

    public CafeController(){
        this.cardapio = new ArrayList<>();
        this.historicoVendas = new ArrayList<>();
        this.view = new CafeView();
        inicializarProdutos();
        abrirNovoPedido();
    }
    private void inicializarProdutos(){
        cardapio.add(new Expresso(1));
        cardapio.add(new Latte(2));
        cardapio.add(new Mocha(3));
    }
    private void abrirNovoPedido(){
        Cliente cliente = new Cliente();
        this.pedidoAtual = new Pedido(cliente, new Date());
    }
    public void iniciar(){
        boolean executando = true;
        while(executando){
            view.exibirCardapio(cardapio);
            int opcao = view.lerOpcao();
            switch(opcao ){
                case 0 -> {
                    executando = false;
                view.exibirMensagem("Fechando o café.");
                }
                case 4 -> finalizarPedido();
                case 5 -> gerarRelatorio();
                default -> processarEscolhaProduto(opcao);
            }
        }
    }
    private void processarEscolhaProduto(int opcao){
        Produto produtoEscolhido = null;
        for(Produto p : cardapio){
            if(p.getIdProduto() == opcao){
                produtoEscolhido = p;
                break;
            }
        }
        if(produtoEscolhido != null){
            pedidoAtual.AdicionarProduto(produtoEscolhido);

            if(produtoEscolhido instanceof Bebida){
                ((Bebida) produtoEscolhido).preparar();
            }
        }
        else{
            view.exibirMensagem("Opção inválida");
        }
    }
    private void finalizarPedido(){
        if(pedidoAtual != null){
            view.exibirMensagem("Pedido finalizado com sucesso!");
            pedidoAtual.exibirDados();
            historicoVendas.add(pedidoAtual);
            abrirNovoPedido();
        }
    }
    private void gerarRelatorio() {
        double totalArrecadado = 0.0;
        int qtdExpresso = 0;
        ;
        int qtdLatte = 0;
        int qtdMocha = 0;
        for (Pedido pedido : historicoVendas) {
            for (Produto p : pedido.getProdutos()) {
                totalArrecadado += p.getValor();

                if (p instanceof Expresso) qtdExpresso++;
                else if (p instanceof Latte) qtdLatte++;
                else if (p instanceof Mocha) qtdMocha++;
            }
        }
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("=== RELATÓRIO DO CAIXA ===\n");
        relatorio.append("Data de Geração: ").append(new Date()).append("\n");
        relatorio.append("---------------------------\n");
        relatorio.append("Total de Pedidos: ").append(historicoVendas.size()).append("\n");
        relatorio.append("Faturamento Total: R$ ").append(String.format("%.2f", totalArrecadado)).append("\n");
        relatorio.append("--- Vendas por Produto ---\n");
        relatorio.append("Espressos: ").append(qtdExpresso).append("\n");
        relatorio.append("Lattes:    ").append(qtdLatte).append("\n");
        relatorio.append("Mochas:    ").append(qtdMocha).append("\n");
        relatorio.append("===========================\n");
        System.out.println(relatorio.toString());

        try(BufferedWriter writer = new BufferedWriter(new FileWriter("relatorio_caixa.txt"))){
            writer.write(relatorio.toString());
            System.out.println(">> Arquivo 'relatorio_caixa,txt' gerado com sucesso!");
        }
        catch(IOException e){
            System.err.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }
}
