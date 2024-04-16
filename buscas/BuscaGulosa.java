import java.util.*;

public class BuscaGulosa {

    static class No {
        int dado;
        No[] filhos;

        No(int dado, No[] filhos) {
            this.dado = dado;
            this.filhos = filhos;
        }
    }

    public static void buscaGulosa(No raiz, int objetivo) {
        Queue<No> fila = new PriorityQueue<>(Comparator.comparingInt(a -> heuristica(a.dado, objetivo)));
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
        No[] filhos1 = {new No(5, new No[]{}), new No(7, new No[]{})};
        No[] filhos2 = {new No(2, new No[]{}), new No(6, new No[]{})};
        No raiz = new No(1, new No[]{new No(3, filhos1), new No(4, filhos2)});
        System.out.println("Busca Gulosa:");
        buscaGulosa(raiz, 6);
    }
}
