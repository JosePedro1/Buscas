import java.util.*;

public class BuscaAStar {

    static class No {
        int dado;
        No[] filhos;
        int custo;

        No(int dado, No[] filhos, int custo) {
            this.dado = dado;
            this.filhos = filhos;
            this.custo = custo;
        }
    }

    public static void buscaAStar(No raiz, int objetivo) {
        Queue<No> fila = new PriorityQueue<>(Comparator.comparingInt(a -> (a.custo + heuristica(a.dado, objetivo))));
        Set<No> visitados = new HashSet<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            No atual = fila.poll();
            if (atual.dado == objetivo) {
                System.out.println("Nó objetivo encontrado: " + atual.dado);
                return;
            }

            visitados.add(atual);
            for (No filho : atual.filhos) {
                if (!visitados.contains(filho)) {
                    fila.add(filho);
                }
            }
        }
        System.out.println("Nó objetivo não encontrado.");
    }

    private static int heuristica(int atual, int objetivo) {
        // Função heurística, por exemplo, distância de Manhattan entre o nó atual e o nó objetivo
        return Math.abs(objetivo - atual);
    }

    public static void main(String[] args) {
        No[] filhos1 = {new No(5, new No[]{}, 3), new No(7, new No[]{}, 4)};
        No[] filhos2 = {new No(2, new No[]{}, 2), new No(6, new No[]{}, 3)};
        No raiz = new No(1, new No[]{new No(3, filhos1, 2), new No(4, filhos2, 1)}, 1);
        System.out.println("Busca A*:");
        buscaAStar(raiz, 6);
    }
}
