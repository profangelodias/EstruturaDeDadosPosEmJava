package tech.angelofdiasg.estruturas;

public class ListTelefonesNaoOrdenados {
    private Telefone[] telefones;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public ListTelefonesNaoOrdenados() {
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

    public void removerTelefone(Telefone telefone) {
        int index = buscarTelefoneIndex(telefone);
        if (index != -1) {
            // Desloque os elementos após o índice para preencher o espaço do telefone removido
            for (int i = index; i < size - 1; i++) {
                telefones[i] = telefones[i + 1];
            }
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

    private void garantirCapacidade() {
        int novaCapacidade = telefones.length * 2;
        Telefone[] listaTelefones = new Telefone[novaCapacidade];
        for (int i = 0; i < size; i++) {
            listaTelefones[i] = telefones[i];
        }
        telefones = listaTelefones;
    }

    public void exibirTelefones() {
        for (int i = 0; i < size; i++) {
            System.out.println(telefones[i]);
        }
    }

    public static void main(String[] args) {
        ListTelefonesNaoOrdenados minhaLista = new ListTelefonesNaoOrdenados();

        Telefone telefone1 = new Telefone("11", "1234-5678");
        Telefone telefone2 = new Telefone("22", "9876-5432");
        Telefone telefone3 = new Telefone("33", "5555-1234");

        minhaLista.addTelefone(telefone1);
        minhaLista.addTelefone(telefone2);
        minhaLista.addTelefone(telefone3);

        System.out.println("Telefones antes da remoção:");
        minhaLista.exibirTelefones();

        // Remover o telefone2
        minhaLista.removerTelefone(telefone2);

        System.out.println("\nTelefones após a remoção:");
        minhaLista.exibirTelefones();
        
        // Exibe os telefones se a lista não estiver vazia
        if (!minhaLista.isEmpty()) {
            System.out.println("Telefones na lista:");
            minhaLista.exibirTelefones();
        } else {
            System.out.println("A lista de telefones está vazia.");
        }
    }
}
