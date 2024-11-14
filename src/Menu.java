import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private List<Produto> catalogo;
    private Carrinho carrinho;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.catalogo = new ArrayList<>();
        this.carrinho = new Carrinho();

        // Preenchendo o catálogo de produtos
        catalogo.add(new Produto("Produto 1", 10.0));
        catalogo.add(new Produto("Produto 2", 20.0));
        catalogo.add(new Produto("Produto 3", 30.0));
    }

    // Método para exibir o menu
    public void exibirMenu() {
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Ver Produtos");
            System.out.println("2. Ver Pontos de Fidelidade");
            System.out.println("3. Finalizar Compra");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    selecionarProduto();
                    break;
                case 2:
                    exibirPontosFidelidade();
                    break;
                case 3:
                    finalizarCompra();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    return; // Sai do menu e encerra o programa
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    // Método para mostrar os produtos e permitir ao usuário escolher
    private void selecionarProduto() {
        while (true) {
            System.out.println("\nProdutos Disponíveis:");
            for (int i = 0; i < catalogo.size(); i++) {
                Produto produto = catalogo.get(i);
                System.out.println((i + 1) + ". " + produto.getNome() + " - R$ " + produto.getPreco());
            }
            System.out.print("\nEscolha o número do produto para adicionar ao carrinho (ou 0 para voltar): ");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            if (escolha == 0) {
                return; // Voltar para o menu
            }

            if (escolha < 1 || escolha > catalogo.size()) {
                System.out.println("Escolha inválida.");
                continue;
            }

            Produto produtoEscolhido = catalogo.get(escolha - 1);

            // Solicitar a quantidade
            System.out.print("Quantos " + produtoEscolhido.getNome() + " você deseja comprar? ");
            int quantidade = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            // Adicionar produto ao carrinho
            carrinho.adicionarProduto(produtoEscolhido, quantidade);

            // Perguntar se o usuário deseja adicionar mais produtos ou finalizar a compra
            System.out.print("\nDeseja adicionar mais produtos? (s/n): ");
            String resposta = scanner.nextLine().toLowerCase();
            if (resposta.equals("n")) {
                break; // Sai da seleção de produtos
            }
        }
    }

    // Método para exibir os pontos de fidelidade
    private void exibirPontosFidelidade() {
        carrinho.exibirPontosFidelidade();
    }

    // Método para finalizar a compra e exibir o resumo
    private void finalizarCompra() {
        System.out.println("\nFinalizando compra...");
        carrinho.exibirResumoCompra();

        // Após finalizar a compra, o sistema retorna ao menu
        System.out.println("\nCompra finalizada! Você voltou ao menu.");
    }
}
