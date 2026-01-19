package domain.exception;

public class ProdutoDuplicadoException extends RuntimeException {

    public ProdutoDuplicadoException(String codigo) {
        super("Já existe um produto cadastrado com o código: " + codigo);
    }
}
