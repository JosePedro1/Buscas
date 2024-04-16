import java.util.LinkedList;
import java.util.Queue;

public class BuscaEmLargura {
    
    static class No {
        int dado;
        No esquerda, direita;
        
        No(int dado) {
            this.dado = dado;
            esquerda = direita = null;
        }
    }
    
    public static void BFS(No raiz) {
        if (raiz == null)
            return;
        
        Queue<No> fila = new LinkedList<>();
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
        
        System.out.println("Busca em Largura:");
        BFS(raiz);
    }
}
