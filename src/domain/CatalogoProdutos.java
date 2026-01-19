package domain;

import java.util.ArrayList;
import java.util.List;
import domain.exception.ProdutoDuplicadoException;
import domain.exception.ProdutoNaoEncontradoException;

public class CatalogoProdutos {

    private List<Produto> produtos;

public CatalogoProdutos() {
    this.produtos = new ArrayList<>();
  }

public void adicionarProduto(Produto produto) {

    if (buscarSeExistir(produto.getCodigo()) != null) {
        throw new ProdutoDuplicadoException(produto.getCodigo());
    }
    produtos.add(produto);
}

public List<Produto> listarProdutos() {
    return produtos;
}

private Produto buscarSeExistir(String codigo) {
    for (Produto p : produtos) {
        if (p.getCodigo().equals(codigo)) {
            return p;
        }
    }
    return null;
}

public Produto buscarPorCodigo(String codigo) {
    Produto produto = buscarSeExistir(codigo);

    if (produto == null) {
        throw new ProdutoNaoEncontradoException(codigo);
    }

    return produto;
}

public void removerProduto(String codigo) {
    Produto produto = buscarPorCodigo(codigo);
    produtos.remove(produto);
}

public void editarProduto(String codigo, String novoNome,
        double novoPreco, TipoProduto novoTipo) {

    Produto produto = buscarPorCodigo(codigo);

    produto.setNome(novoNome);
    produto.setPrecoUnitario(novoPreco);
    produto.setTipo(novoTipo);
}

}
