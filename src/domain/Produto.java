package domain;

public class Produto {

    private String codigo;
    private String nome;
    private double precoUnitario;

    public Produto(String codigo, String nome, double precoUnitario) {
        this.codigo = codigo;
        this.nome = nome;
        this.precoUnitario = precoUnitario;
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
}

