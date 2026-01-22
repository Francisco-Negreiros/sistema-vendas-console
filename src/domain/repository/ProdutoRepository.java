package domain.repository;

import java.util.List;
import domain.Produto;

public interface ProdutoRepository {
	
	boolean existePorCodigo(String codigo);

    void salvar(Produto produto);

    Produto buscarPorCodigo(String codigo);

    List<Produto> listarTodos();

    void remover(Produto produto);
    
    void atualizar(Produto produto);

}
