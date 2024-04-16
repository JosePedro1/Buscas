package desafio;

import java.util.*;

public class ProblemaMochila {

    static class Item {
        int peso;
        int valor;

        Item(int peso, int valor) {
            this.peso = peso;
            this.valor = valor;
        }
    }

    public static int mochilaGulosa(Item[] itens, int capacidade) {
 
        Arrays.sort(itens, (a, b) -> Double.compare((double) b.valor / b.peso, (double) a.valor / a.peso));

        int valorTotal = 0;
        int pesoAtual = 0;

        for (Item item : itens) {
            if (pesoAtual + item.peso <= capacidade) {
             
                valorTotal += item.valor;
                pesoAtual += item.peso;
            } else {
          
                double fracao = (double) (capacidade - pesoAtual) / item.peso;
                valorTotal += item.valor * fracao;
                break;
            }
        }

        return valorTotal;
    }

    public static void main(String[] args) {
        Item[] itens = {
            new Item(10, 60),
            new Item(20, 100),
            new Item(30, 120)
        };

        int capacidade = 50;

        int valorMaximo = mochilaGulosa(itens, capacidade);
        System.out.println("Valor máximo que pode ser colocado na mochila: " + valorMaximo);
    }
}
