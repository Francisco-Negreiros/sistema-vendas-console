package domain.exception;

public class ProdutoNaoEncontradoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

    public ProdutoNaoEncontradoException(String codigo) {
        super("Produto com código '" + codigo + "' não encontrado.");
    }
}