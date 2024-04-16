public class BuscaAprofundamentoIterativo {
    
    static class No {
        int dado;
        No esquerda, direita;
        
        No(int dado) {
            this.dado = dado;
            esquerda = direita = null;
        }
    }
    
    public static void IDDFS(No raiz) {
        int profundidade = 0;
        
        while (true) {
            if (DLS(raiz, profundidade))
                return;
            profundidade++;
        }
    }
    
    public static boolean DLS(No no, int profundidade) {
        if (no == null)
            return false;
        
        if (profundidade == 0) {
            System.out.print(no.dado + " ");
            return true;
        }
        
        boolean esquerda = DLS(no.esquerda, profundidade - 1);
        boolean direita = DLS(no.direita, profundidade - 1);
        
        return esquerda || direita;
    }

    public static void main(String[] args) {
        No raiz = new No(1);
        raiz.esquerda = new No(2);
        raiz.direita = new No(3);
        raiz.esquerda.esquerda = new No(4);
        raiz.esquerda.direita = new No(5);
        
        System.out.println("Busca de Aprofundamento Iterativo:");
        IDDFS(raiz);
    }
}
