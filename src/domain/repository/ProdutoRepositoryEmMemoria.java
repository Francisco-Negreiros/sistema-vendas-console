package domain.repository;

import java.util.ArrayList;
import java.util.List;

import domain.Produto;
import domain.exception.ProdutoNaoEncontradoException;

public class ProdutoRepositoryEmMemoria implements ProdutoRepository {

    private List<Produto> produtos;

    public ProdutoRepositoryEmMemoria() {
        this.produtos = new ArrayList<>();
    }
    

    @Override
    public void salvar(Produto produto) {
        produtos.add(produto);
    }
    
    @Override
    public Produto buscarPorCodigo(String codigo) {
        return produtos.stream()
            .filter(p -> p.getCodigo().equals(codigo))
            .findFirst()
            .orElseThrow(() -> new ProdutoNaoEncontradoException(codigo));
    }

    
    @Override
    public boolean existePorCodigo(String codigo) {
        return produtos.stream()
                .anyMatch(p -> p.getCodigo().equals(codigo));
    }
    

    @Override
    public List<Produto> listarTodos() {
        return produtos;
    }

    @Override
    public void remover(Produto produto) {
        produtos.remove(produto);
    }
    
    @Override
    public void atualizar(Produto produto) {
        // nada a fazer
    }

}
