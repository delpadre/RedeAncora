public class Fidelidade {
    private int pontos;

    public Fidelidade() {
        this.pontos = 0;  // Inicializa com 0 pontos
    }

    // Método para adicionar pontos com base no valor da compra
    public void adicionarPontos(double valorCompra) {
        // Exemplo de regra: 1 ponto para cada R$ 10,00 gastos
        int pontosAdicionados = (int) (valorCompra / 10);
        pontos += pontosAdicionados;
        System.out.println("Você ganhou " + pontosAdicionados + " pontos de fidelidade.");
    }

    // Método para visualizar os pontos de fidelidade acumulados
    public void exibirPontos() {
        System.out.println("Você tem " + pontos + " pontos de fidelidade.");
    }

    // Método para obter os pontos atuais
    public int getPontos() {
        return pontos;
    }
}
