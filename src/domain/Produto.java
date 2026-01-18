package domain;


public class Produto {

    private String codigo;
    private String nome;
    private double precoUnitario;
    private TipoProduto tipo;
    

    public Produto(String codigo, String nome, double precoUnitario, TipoProduto tipo) {
        this.codigo = codigo;
        this.nome = nome;
        this.precoUnitario = precoUnitario;
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }
    
    public double getPrecoUnitario() {
        return precoUnitario;
    }
    
    public TipoProduto getTipo() {
        return tipo;
    }
    
    @Override
    public String toString() {
        return "Código: " + codigo +
               " | Nome: " + nome +
               " | Preço: R$ " + precoUnitario +
               " | Tipo: " + tipo;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Produto other = (Produto) obj;
        return codigo.equals(other.codigo);
    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }

}

