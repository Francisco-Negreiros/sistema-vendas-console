package application;

import java.util.Scanner;

import domain.CatalogoProdutos;
import domain.Produto;
import domain.TipoProduto;

public class ConsoleUI {

    private Scanner scanner;
    private CatalogoProdutos catalogo;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
        this.catalogo = new CatalogoProdutos();
    }

    public void iniciar() {

        int opcao = 0;

        do {
            mostrarMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpa o buffer

            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;

                case 2:
                    listarProdutos();
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    private void mostrarMenu() {
        System.out.println("\n=== SISTEMA DE VENDAS ===");
        System.out.println("1 - Cadastrar produto");
        System.out.println("2 - Listar produtos");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private void cadastrarProduto() {

        System.out.print("Código do produto: ");
        String codigo = scanner.nextLine();

        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Preço unitário: ");
        double preco = scanner.nextDouble();
        scanner.nextLine(); // limpa buffer

        System.out.print("Tipo (1 - UNIDADE | 2 - PESO): ");
        int tipoEscolha = scanner.nextInt();
        scanner.nextLine(); // limpa buffer

        TipoProduto tipo;

        if (tipoEscolha == 1) {
            tipo = TipoProduto.UNIDADE;
        } else {
            tipo = TipoProduto.PESO;
        }

        Produto produto = new Produto(codigo, nome, preco, tipo);

        boolean sucesso = catalogo.adicionarProduto(produto);

        if (sucesso) {
            System.out.println("✅ Produto cadastrado com sucesso!");
        } else {
            System.out.println("Erro: já existe um produto com esse código.");
        }
        
    }

    private void listarProdutos() {

        if (catalogo.listarProdutos().isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        System.out.println("\n--- Produtos cadastrados ---");
        for (Produto produto : catalogo.listarProdutos()) {
            System.out.println(produto);
        }
    }
}
