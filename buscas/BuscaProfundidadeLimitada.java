import java.util.Stack;

public class BuscaProfundidadeLimitada {
    
    static class No {
        int dado;
        No esquerda, direita;
        
        No(int dado) {
            this.dado = dado;
            esquerda = direita = null;
        }
    }
    
    public static void DLS(No raiz, int limite) {
        if (raiz == null)
            return;
        
        Stack<No> pilha = new Stack<>();
        pilha.push(raiz);
        
        while (!pilha.isEmpty()) {
            No no = pilha.pop();
            System.out.print(no.dado + " ");
            
            if (no.direita != null && limite > 0)
                pilha.push(no.direita);
            
            if (no.esquerda != null && limite > 0)
                pilha.push(no.esquerda);
            
            limite--;
        }
    }

    public static void main(String[] args) {
        No raiz = new No(1);
        raiz.esquerda = new No(2);
        raiz.direita = new No(3);
        raiz.esquerda.esquerda = new No(4);
        raiz.esquerda.direita = new No(5);
        
        System.out.println("Busca em Profundidade Limitada com limite 3:");
        DLS(raiz, 3);
    }
}
