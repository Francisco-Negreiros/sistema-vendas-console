package domain.exception;

public class ProdutoDuplicadoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

    public ProdutoDuplicadoException(String codigo) {
        super("Já existe um produto cadastrado com o código: " + codigo);
    }
}
