package tech.angelofdiasg.estruturas;

import java.util.LinkedList;
import java.util.Queue;

public class FilaDeClientesQueue {
    private Queue<Cliente> fila;

    public FilaDeClientesQueue() {
        this.fila = new LinkedList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        fila.offer(cliente);
        System.out.println("Cliente " + cliente.getNome() + " adicionado à fila.");
    }

    public Cliente atenderProximoCliente() {
        Cliente clienteAtendido = fila.poll();
        if (clienteAtendido != null) {
            System.out.println("Atendendo cliente " + clienteAtendido.getNome() + ".");
        } else {
            System.out.println("A fila está vazia. Não há clientes para atender.");
        }
        return clienteAtendido;
    }

    public void exibirFila() {
        System.out.println("Fila de clientes:");
        for (Cliente cliente : fila) {
            System.out.println(cliente.getNome());
        }
    }

    public static void main(String[] args) {
        FilaDeClientesQueue filaClientes = new FilaDeClientesQueue();

        Cliente cliente1 = new Cliente("João");
        Cliente cliente2 = new Cliente("Maria");
        Cliente cliente3 = new Cliente("Pedro");

        filaClientes.adicionarCliente(cliente1);
        filaClientes.adicionarCliente(cliente2);
        filaClientes.adicionarCliente(cliente3);

        filaClientes.exibirFila();

        filaClientes.atenderProximoCliente();
        filaClientes.atenderProximoCliente();

        filaClientes.exibirFila();
    }
}
