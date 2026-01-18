package application;

import domain.ItemVenda;
import domain.Produto;
import domain.Venda;
import domain.TipoProduto;

public class Program {

    public static void main(String[] args) {

        // Criando produtos
    	Produto arroz = new Produto("001", "Arroz", 7.50, TipoProduto.UNIDADE);
        Produto feijao = new Produto("002", "Feijão", 8.90, TipoProduto.PESO);

        // Criando itens da venda
        ItemVenda item1 = new ItemVenda(arroz, 2);
        ItemVenda item2 = new ItemVenda(feijao, 1.5);

        // Criando a venda
        Venda venda = new Venda();
        venda.adicionarItem(new ItemVenda(arroz, 2));
        venda.adicionarItem(new ItemVenda(feijao, 1.5));
        
        // Chama o método que imprime a venda
        venda.imprimirResumo();
    }
}
