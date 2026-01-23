package application;

import java.util.Scanner;
import domain.CatalogoProdutos;
import domain.Produto;
import domain.TipoProduto;
import domain.exception.ProdutoDuplicadoException;
import domain.exception.ProdutoNaoEncontradoException;
import domain.repository.ProdutoRepositoryArquivo;

public class ConsoleUI {
	
    private Scanner scanner;
    private CatalogoProdutos catalogo;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
        
        ProdutoRepositoryArquivo repository = new ProdutoRepositoryArquivo();
        this.catalogo = new CatalogoProdutos(repository);
        		
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
                
                case 3:
                	buscarProduto();
                	break;
                	
                case 4:
                	removerProduto();
                	break;
                	
                case 5:
                    editarProduto();
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
        System.out.println("3 - Buscar produto por código");
        System.out.println("4 - Remover produto");
        System.out.println("5 - Editar produto");
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
        
        try {
            catalogo.adicionarProduto(produto);
            System.out.println("✅ Produto cadastrado com sucesso!");
        } catch (ProdutoDuplicadoException e) {
            System.out.println("❌ " + e.getMessage());
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


    private void buscarProduto() {

        System.out.print("Código do produto: ");
        String codigo = scanner.nextLine();

        try {
            Produto produto = catalogo.buscarPorCodigo(codigo);
            System.out.println("✅ Produto encontrado:");
            System.out.println(produto);

        } catch (ProdutoNaoEncontradoException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }
    
    private void removerProduto() {

        System.out.print("Código do produto a remover: ");
        String codigo = scanner.nextLine();

        try {
            catalogo.removerProduto(codigo);
            System.out.println("🗑️ Produto removido com sucesso!");
        } catch (ProdutoNaoEncontradoException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }
    
    private void editarProduto() {

        System.out.print("Digite o código do produto: ");
        String codigo = scanner.nextLine();

        try {
            Produto produto = catalogo.buscarPorCodigo(codigo);
            System.out.println("Editando: " + produto);

            System.out.print("Novo nome: ");
            String nome = scanner.nextLine();

            System.out.print("Novo preço: ");
            double preco = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Tipo (1 - UNIDADE | 2 - PESO): ");
            int tipoEscolha = scanner.nextInt();
            scanner.nextLine();

            TipoProduto tipo = (tipoEscolha == 1)
                    ? TipoProduto.UNIDADE
                    : TipoProduto.PESO;

            catalogo.editarProduto(codigo, nome, preco, tipo);
            System.out.println("✅ Produto editado com sucesso!");

        } catch (ProdutoNaoEncontradoException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

}
