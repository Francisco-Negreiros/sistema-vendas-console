package domain;

import java.util.ArrayList;
import java.util.List;

public class CatalogoProdutos {

    private List<Produto> produtos;

public CatalogoProdutos() {
    this.produtos = new ArrayList<>();
  }

/*public void cadastrarProduto(Produto produto) {
    produtos.add(produto);
}*/

public boolean adicionarProduto(Produto produto) {
    if (produtos.contains(produto)) {
        return false; // já existe
    }
    produtos.add(produto);
    return true;
}

public List<Produto> listarProdutos() {
    return produtos;
}

public Produto buscarPorCodigo(String codigo) {
    for (Produto produto : produtos) {
        if (produto.getCodigo().equalsIgnoreCase(codigo)) {
            return produto;
        }
    }
    return null;
}


}
