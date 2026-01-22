package domain.repository;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import domain.Produto;
import domain.TipoProduto;
import domain.exception.ProdutoNaoEncontradoException;

public class ProdutoRepositoryArquivo implements ProdutoRepository {
	
	
	private static final String CAMINHO_ARQUIVO = "dados/produtos.txt";
	
	public ProdutoRepositoryArquivo() {
	    carregarDoArquivo();
	}
	
	private List<Produto> produtos = new ArrayList<>();
	
	private void carregarDoArquivo() {

	    File arquivo = new File(CAMINHO_ARQUIVO);

	    if (!arquivo.exists()) {
	        return; // primeira execução
	    }

	    try (BufferedReader reader = new BufferedReader(
	            new FileReader(arquivo))) {

	        String linha;

	        while ((linha = reader.readLine()) != null) {

	            String[] dados = linha.split(";");

	            String codigo = dados[0];
	            String nome = dados[1];
	            double preco = Double.parseDouble(dados[2]);
	            TipoProduto tipo = TipoProduto.valueOf(dados[3]);

	            Produto produto = new Produto(codigo, nome, preco, tipo);
	            produtos.add(produto);
	        }

	    } catch (IOException e) {
	        throw new RuntimeException("Erro ao carregar produtos do arquivo", e);
	    }
	}

	@Override
	public void salvar(Produto produto) {

	    produtos.add(produto);

	    File arquivo = new File(CAMINHO_ARQUIVO);
	    arquivo.getParentFile().mkdirs(); // 🔥 ESSA LINHA É A CHAVE

	    try (BufferedWriter writer = new BufferedWriter(
	            new FileWriter(arquivo, true))) {

	        String linha = produto.getCodigo() + ";" +
	                       produto.getNome() + ";" +
	                       produto.getPrecoUnitario() + ";" +
	                       produto.getTipo();

	        writer.write(linha);
	        writer.newLine();

	    } catch (IOException e) {
	        throw new RuntimeException("Erro ao salvar produto em arquivo", e);
	    }
	}

    @Override
    public Produto buscarPorCodigo(String codigo) {
        for (Produto p : produtos) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        throw new ProdutoNaoEncontradoException(codigo);
    }

    @Override
    public List<Produto> listarTodos() {
        return produtos;
    }

    
    private void reescreverArquivo() {

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(CAMINHO_ARQUIVO))) {

            for (Produto produto : produtos) {

                String linha = produto.getCodigo() + ";" +
                               produto.getNome() + ";" +
                               produto.getPrecoUnitario() + ";" +
                               produto.getTipo();

                writer.write(linha);
                writer.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException("Erro ao reescrever arquivo de produtos", e);
        }
    }
    
    
    @Override
    public void atualizar(Produto produto) {
        reescreverArquivo();
    }
    
    @Override
    public void remover(Produto produto) {
        produtos.remove(produto);
        reescreverArquivo();
    }

    
    @Override
    public boolean existePorCodigo(String codigo) {
        for (Produto p : produtos) {
            if (p.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }


}

