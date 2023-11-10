package tech.angelofdiasg.desafios;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class EscapadaDoCavalo {

    public static int soldadoSorteado(int numSoldados) {
        Random rand = new Random();
        return rand.nextInt(numSoldados) + 1;
    }

    public static int escaparDoCirculo(int numSoldados, int passo) {
        Queue<Integer> circulo = new LinkedList<>();

        // Inicializar o círculo de soldados
        for (int i = 1; i <= numSoldados; i++) {
            circulo.offer(i);
        }

        while (circulo.size() > 1) {
            // Sorteia o número para a contagem
            int numeroSorteado = soldadoSorteado(numSoldados);

            // Conta até o número sorteado e remove o soldado correspondente
            for (int i = 1; i < numeroSorteado; i++) {
                circulo.offer(circulo.poll()); // Move o soldado para o final do círculo
            }

            // Remove o soldado atual
            circulo.poll();
        }

        // O único soldado restante é escolhido para a tarefa
        return circulo.poll();
    }

    public static void main(String[] args) {
        int numSoldados = 10; // Altere conforme o número de soldados no círculo
        int passo = 3; // Altere conforme a contagem desejada

        int soldadoEscolhido = escaparDoCirculo(numSoldados, passo);

        System.out.println("Soldado escolhido para a escapada: " + soldadoEscolhido);
    }
}

