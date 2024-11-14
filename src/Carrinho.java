import java.util.HashMap;
import java.util.Map;

public class Carrinho {
    private Map<Produto, Integer> produtos;
    private int pontosFidelidade;

    public Carrinho() {
        produtos = new HashMap<>();
        pontosFidelidade = 0;
    }

    // Método para adicionar produtos ao carrinho
    public void adicionarProduto(Produto produto, int quantidade) {
        if (produtos.containsKey(produto)) {
            produtos.put(produto, produtos.get(produto) + quantidade);
        } else {
            produtos.put(produto, quantidade);
        }
    }

    // Método para calcular o total da compra
    public double calcularTotalCompra() {
        double total = 0.0;
        for (Map.Entry<Produto, Integer> entry : produtos.entrySet()) {
            total += entry.getKey().getPreco() * entry.getValue();
        }

        // Atualizando os pontos de fidelidade (1 ponto a cada 10 reais)
        pontosFidelidade = (int) (total / 10);

        return total;
    }

    // Método para exibir o resumo da compra
    public void exibirResumoCompra() {
        double totalCompra = calcularTotalCompra();
        System.out.println("\nResumo da Compra:");
        for (Map.Entry<Produto, Integer> entry : produtos.entrySet()) {
            System.out.println(entry.getKey().getNome() + " - Quantidade: " + entry.getValue() + " - Preço: R$ " + entry.getKey().getPreco());
        }
        System.out.println("Total da Compra: R$ " + totalCompra);
        System.out.println("Pontos de Fidelidade: " + pontosFidelidade);
    }

    // Método para exibir os pontos de fidelidade
    public void exibirPontosFidelidade() {
        System.out.println("Pontos de Fidelidade: " + pontosFidelidade);
    }
}
