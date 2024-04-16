import java.util.PriorityQueue;

public class BuscaCustoUniforme {
    
    static class No implements Comparable<No> {
        int dado;
        No esquerda, direita;
        
        No(int dado) {
            this.dado = dado;
            esquerda = direita = null;
        }
        
        @Override
        public int compareTo(No outro) {
            return this.dado - outro.dado;
        }
    }
    
    public static void UCS(No raiz) {
        if (raiz == null)
            return;
        
        PriorityQueue<No> fila = new PriorityQueue<>();
        fila.add(raiz);
        
        while (!fila.isEmpty()) {
            No no = fila.poll();
            System.out.print(no.dado + " ");
            
            if (no.esquerda != null)
                fila.add(no.esquerda);
            
            if (no.direita != null)
                fila.add(no.direita);
        }
    }

    public static void main(String[] args) {
        No raiz = new No(1);
        raiz.esquerda = new No(2);
        raiz.direita = new No(3);
        raiz.esquerda.esquerda = new No(4);
        raiz.esquerda.direita = new No(5);
        
        System.out.println("Busca de Custo Uniforme:");
        UCS(raiz);
    }
}
