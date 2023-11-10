package tech.angelofdiasg.estruturas;

import java.util.Arrays;

public class ListTelefonesNaoOrdenadosComArrays {
    private Telefone[] telefones;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public ListTelefonesNaoOrdenadosComArrays() {
        this.telefones = new Telefone[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addTelefone(Telefone telefone) {
        if (size == telefones.length) {
            // Se o vetor estiver cheio, aumente sua capacidade
        	garantirCapacidade();
        }
        telefones[size++] = telefone;
    }

    private void garantirCapacidade() {
        int newCapacity = telefones.length * 2;
        telefones = Arrays.copyOf(telefones, newCapacity);
    }

    public void exibirTelefones() {
        for (int i = 0; i < size; i++) {
            System.out.println(telefones[i]);
        }
    }
    
    public void removerTelefone(Telefone telefone) {
        int index = buscarTelefoneIndex(telefone);
        if (index != -1) {
            // Desloque os elementos após o índice para preencher o espaço do telefone removido
            System.arraycopy(telefones, index + 1, telefones, index, size - index - 1);
            // Defina o último elemento como null e diminua o tamanho
            telefones[--size] = null;
        }
    }

    private int buscarTelefoneIndex(Telefone telefone) {
        for (int i = 0; i < size; i++) {
            if (telefones[i].equals(telefone)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
    	ListTelefonesNaoOrdenadosComArrays minhaLista = new ListTelefonesNaoOrdenadosComArrays();

        Telefone telefone1 = new Telefone("11", "1234-5678");
        Telefone telefone2 = new Telefone("22", "9876-5432");
        Telefone telefone3 = new Telefone("33", "5555-1234");

        minhaLista.addTelefone(telefone1);
        minhaLista.addTelefone(telefone2);
        minhaLista.addTelefone(telefone3);

        System.out.println("Telefones:");
        minhaLista.exibirTelefones();
    }
}
