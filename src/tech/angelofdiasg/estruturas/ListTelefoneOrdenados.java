package tech.angelofdiasg.estruturas;


//Ordena por DDD, mudar para Id
public class ListTelefoneOrdenados {

    private Telefone[] telefones;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public ListTelefoneOrdenados() {
        this.telefones = new Telefone[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addTelefone(Telefone telefone) {
        if (size == telefones.length) {
            // Se o vetor estiver cheio, aumente sua capacidade
            ensureCapacity();
        }

        // Encontrar a posição correta para inserir o telefone ordenadamente
        int index = findInsertionIndex(telefone);

        // Deslocar os elementos para abrir espaço para o novo telefone
        for (int i = size - 1; i >= index; i--) {
            telefones[i + 1] = telefones[i];
        }

        // Inserir o novo telefone na posição correta
        telefones[index] = telefone;
        size++;
    }

    private int findInsertionIndex(Telefone telefone) {
        int index = 0;
        while (index < size && telefones[index].getDdd().compareTo(telefone.getDdd()) < 0) {
            index++;
        }
        return index;
    }

    private void ensureCapacity() {
        int newCapacity = telefones.length * 2;
        Telefone[] newTelefones = new Telefone[newCapacity];
        for (int i = 0; i < size; i++) {
            newTelefones[i] = telefones[i];
        }
        telefones = newTelefones;
    }

    public void displayTelefones() {
        for (int i = 0; i < size; i++) {
            System.out.println(telefones[i]);
        }
    }

    public static void main(String[] args) {
        ListTelefoneOrdenados minhaLista = new ListTelefoneOrdenados();

        Telefone telefone1 = new Telefone("11", "1234-5678");
        Telefone telefone2 = new Telefone("22", "9876-5432");
        Telefone telefone3 = new Telefone("33", "5555-1234");

        minhaLista.addTelefone(telefone3);
        minhaLista.addTelefone(telefone1);
        minhaLista.addTelefone(telefone2);

        System.out.println("Telefones na lista ordenada:");
        minhaLista.displayTelefones();
    }


}
