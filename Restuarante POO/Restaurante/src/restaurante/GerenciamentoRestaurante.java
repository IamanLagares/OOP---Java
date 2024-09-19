package restaurante;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe Cliente
class Cliente {
    private String nome;
    private String contato;

    public Cliente(String nome, String contato) {
        this.nome = nome;
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Cliente: " + nome + ", Contato: " + contato;
    }
}

// Classe Garcom
class Garcom {
    private String nome;

    public Garcom(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Garçom: " + nome;
    }
}

// Classe Item do Menu
class ItemMenu {
    private String nome;
    private String descricao;
    private double preco;

    public ItemMenu(String nome, String descricao, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return nome + " (" + descricao + ") - R$ " + preco;
    }
}

class PedidoItem {
    private ItemMenu item;
    private int quantidade;

    public PedidoItem(ItemMenu item, int quantidade) {
        this.item = item;
        this.quantidade = quantidade;
    }

    public double calcularSubtotal() {
        return item.getPreco() * quantidade;
    }

    @Override
    public String toString() {
        return item.getNome() + " x" + quantidade + " = R$ " + calcularSubtotal();
    }
}


class Pedido {
    private Cliente cliente;
    private Garcom garcom;
    private List<PedidoItem> itens;

    public Pedido(Cliente cliente, Garcom garcom) {
        this.cliente = cliente;
        this.garcom = garcom;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemMenu item, int quantidade) {
        itens.add(new PedidoItem(item, quantidade));
    }

    public double calcularTotal() {
        double total = 0;
        for (PedidoItem pedidoItem : itens) {
            total += pedidoItem.calcularSubtotal();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido:\n");
        sb.append(cliente).append("\n");
        sb.append(garcom).append("\n");
        sb.append("Itens:\n");
        for (PedidoItem item : itens) {
            sb.append("  - ").append(item).append("\n");
        }
        sb.append("Total: R$ ").append(calcularTotal());
        return sb.toString();
    }
}

// Classe principal do sistema
public class GerenciamentoRestaurante {
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Garcom> garcons = new ArrayList<>();
    private static List<ItemMenu> menu = new ArrayList<>();
    private static List<Pedido> pedidos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Cadastro inicial de itens no menu
        menu.add(new ItemMenu("Pizza", "Pizza de queijo", 25.0));
        menu.add(new ItemMenu("Suco", "Suco de laranja", 5.0));
        menu.add(new ItemMenu("Hambúrguer", "Hambúrguer de carne", 15.0));
        // Itens adicionais
        menu.add(new ItemMenu("Batata Frita", "Porção de batata frita", 10.0));
        menu.add(new ItemMenu("Café", "Café expresso", 4.0));
        menu.add(new ItemMenu("Salada", "Salada verde com tomate", 12.0));

        // Cadastro inicial de clientes e garçons
        clientes.add(new Cliente("Maria", "maria@gmail.com"));
        clientes.add(new Cliente("João", "joao@gmail.com"));
        garcons.add(new Garcom("Carlos"));
        garcons.add(new Garcom("Fernanda"));

        boolean rodando = true;
        while (rodando) {
            System.out.println("\n--- Sistema de Gerenciamento de Pedidos ---");
            System.out.println("1. Fazer Pedido");
            System.out.println("2. Listar Pedidos");
            System.out.println("3. Adicionar Cliente");
            System.out.println("4. Adicionar Garçom");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    fazerPedido(scanner);
                    break;
                case 2:
                    listarPedidos();
                    break;
                case 3:
                    adicionarCliente(scanner);
                    break;
                case 4:
                    adicionarGarcom(scanner);
                    break;
                case 5:
                    rodando = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }

    private static void fazerPedido(Scanner scanner) {
        if (clientes.isEmpty() || garcons.isEmpty()) {
            System.out.println("Cadastre pelo menos um cliente e um garçom antes de fazer um pedido.");
            return;
        }

        System.out.println("\nSelecione um cliente:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(i + 1 + ". " + clientes.get(i).getNome());
        }
        int clienteIndex = scanner.nextInt() - 1;

        System.out.println("\nSelecione um garçom:");
        for (int i = 0; i < garcons.size(); i++) {
            System.out.println(i + 1 + ". " + garcons.get(i).getNome());
        }
        int garcomIndex = scanner.nextInt() - 1;

        Pedido pedido = new Pedido(clientes.get(clienteIndex), garcons.get(garcomIndex));

        boolean adicionandoItens = true;
        while (adicionandoItens) {
            System.out.println("\nSelecione um item do menu:");
            for (int i = 0; i < menu.size(); i++) {
                System.out.println(i + 1 + ". " + menu.get(i));
            }
            int itemIndex = scanner.nextInt() - 1;

            System.out.print("Quantidade: ");
            int quantidade = scanner.nextInt();

            pedido.adicionarItem(menu.get(itemIndex), quantidade);

            System.out.print("Deseja adicionar mais itens? (S/N): ");
            char continuar = scanner.next().toLowerCase().charAt(0);
            if (continuar == 'n') {
                adicionandoItens = false;
            }
        }

        pedidos.add(pedido);
        System.out.println("\nPedido realizado com sucesso!");
    }

    // Função para listar todos os pedidos
    private static void listarPedidos() {
        System.out.println("\n--- Pedidos Realizados ---");
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido foi realizado ainda.");
        } else {
            for (Pedido pedido : pedidos) {
                System.out.println(pedido);
                System.out.println("------------------------------");
            }
        }
    }

    // Função para adicionar um cliente manualmente
    private static void adicionarCliente(Scanner scanner) {
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Contato do cliente: ");
        String contato = scanner.nextLine();
        clientes.add(new Cliente(nome, contato));
        System.out.println("Cliente adicionado com sucesso!");
    }

    // Função para adicionar um garçom manualmente
    private static void adicionarGarcom(Scanner scanner) {
        System.out.print("Nome do garçom: ");
        String nome = scanner.nextLine();
        garcons.add(new Garcom(nome));
        System.out.println("Garçom adicionado com sucesso!");
    }
}
