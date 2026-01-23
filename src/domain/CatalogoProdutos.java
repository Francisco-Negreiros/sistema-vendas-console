package domain;

import java.util.List;

import domain.exception.ProdutoDuplicadoException;
import domain.repository.ProdutoRepository;

public class CatalogoProdutos {

	private ProdutoRepository repository;

	public CatalogoProdutos(ProdutoRepository repository) {
	    this.repository = repository;
	}
	
	public void adicionarProduto(Produto produto) {

	    if (repository.existePorCodigo(produto.getCodigo())) {
	        throw new ProdutoDuplicadoException(produto.getCodigo());
	    }

	    repository.salvar(produto);
	}


	public List<Produto> listarProdutos() {
	    return repository.listarTodos();
	}


	public Produto buscarPorCodigo(String codigo) {
	    return repository.buscarPorCodigo(codigo);
	}
	
	public void removerProduto(String codigo) {
	    Produto produto = repository.buscarPorCodigo(codigo);
	    repository.remover(produto);
	}

	public void editarProduto(String codigo, String novoNome, double novoPreco, TipoProduto novoTipo) {

	    Produto produto = repository.buscarPorCodigo(codigo);

	    produto.setNome(novoNome);
	    produto.setPrecoUnitario(novoPreco);
	    produto.setTipo(novoTipo);
	    repository.atualizar(produto);
	}
	
}
