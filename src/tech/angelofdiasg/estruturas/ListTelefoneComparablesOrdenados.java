package tech.angelofdiasg.estruturas;

public class ListTelefoneComparablesOrdenados {

    private TelefoneComparable[] TelefoneComparables;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public ListTelefoneComparablesOrdenados() {
        this.TelefoneComparables = new TelefoneComparable[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addTelefoneComparable(TelefoneComparable TelefoneComparable) {
        if (size == TelefoneComparables.length) {
            // Se o vetor estiver cheio, aumente sua capacidade
            ensureCapacity();
        }

        // Encontrar a posição correta para inserir o TelefoneComparable ordenadamente
        int index = findInsertionIndex(TelefoneComparable);

        // Deslocar os elementos para abrir espaço para o novo TelefoneComparable
        for (int i = size - 1; i >= index; i--) {
            TelefoneComparables[i + 1] = TelefoneComparables[i];
        }

        // Inserir o novo TelefoneComparable na posição correta
        TelefoneComparables[index] = TelefoneComparable;
        size++;
    }

    private int findInsertionIndex(TelefoneComparable TelefoneComparable) {
        int index = 0;
        while (index < size && TelefoneComparables[index].compareTo(TelefoneComparable) < 0) {
            index++;
        }
        return index;
    }

    private void ensureCapacity() {
        int newCapacity = TelefoneComparables.length * 2;
        TelefoneComparable[] newTelefoneComparables = new TelefoneComparable[newCapacity];
        for (int i = 0; i < size; i++) {
            newTelefoneComparables[i] = TelefoneComparables[i];
        }
        TelefoneComparables = newTelefoneComparables;
    }

    public void displayTelefoneComparables() {
        for (int i = 0; i < size; i++) {
            System.out.println(TelefoneComparables[i]);
        }
    }

    public static void main(String[] args) {
        ListTelefoneComparablesOrdenados minhaLista = new ListTelefoneComparablesOrdenados();

        TelefoneComparable TelefoneComparable1 = new TelefoneComparable("11", "1234-5678");
        TelefoneComparable TelefoneComparable2 = new TelefoneComparable("22", "9876-5432");
        TelefoneComparable TelefoneComparable3 = new TelefoneComparable("33", "5555-1234");

        minhaLista.addTelefoneComparable(TelefoneComparable3);
        minhaLista.addTelefoneComparable(TelefoneComparable1);
        minhaLista.addTelefoneComparable(TelefoneComparable2);

        System.out.println("TelefoneComparables na lista ordenada:");
        minhaLista.displayTelefoneComparables();
    }

	
}
