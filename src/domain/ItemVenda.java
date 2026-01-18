package domain;

public class ItemVenda {

    private Produto produto;
    private int quantidade;     // usado se for UNIDADE
    private double peso;        // usado se for PESO

    // Construtor para produto por UNIDADE
    public ItemVenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    // Construtor para produto por PESO
    public ItemVenda(Produto produto, double peso) {
        this.produto = produto;
        this.peso = peso;
    }
    
    public Produto getProduto() {
        return produto;
    }


    public double calcularSubtotal() {
        if (produto.getTipo() == TipoProduto.UNIDADE) {
            return produto.getPrecoUnitario() * quantidade;
        } else {
            return produto.getPrecoUnitario() * peso;
        }
    }
}
