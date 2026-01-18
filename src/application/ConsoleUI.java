package application;

import java.util.Scanner;

public class ConsoleUI {

    private Scanner sc;

    public ConsoleUI() {
        sc = new Scanner(System.in);
    }

    public void iniciar() {
        int opcao;

        do {
            mostrarMenu();
            opcao = sc.nextInt();
            tratarOpcao(opcao);
        } while (opcao != 0);

        sc.close();
        System.out.println("Sistema encerrado.");
    }

    private void mostrarMenu() {
        System.out.println("\n=== SISTEMA DE VENDAS ===");
        System.out.println("1 - Cadastrar produto");
        System.out.println("2 - Iniciar venda");
        System.out.println("3 - Adicionar item");
        System.out.println("4 - Finalizar venda");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private void tratarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                System.out.println("Cadastrar produto");
                break;
            case 2:
                System.out.println("Iniciar venda");
                break;
            case 3:
                System.out.println("Adicionar item");
                break;
            case 4:
                System.out.println("Finalizar venda");
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }
}
