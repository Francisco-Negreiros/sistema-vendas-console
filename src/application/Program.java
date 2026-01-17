package application;

import domain.ItemVenda;
import domain.Produto;
import domain.Venda;

public class Program {

    public static void main(String[] args) {

        // 1️⃣ Criando produtos
        Produto arroz = new Produto("Arroz 1kg", 7.50);
        Produto feijao = new Produto("Feijão 1kg", 8.90);

        // 2️⃣ Criando itens da venda
        ItemVenda item1 = new ItemVenda(arroz, 2);
        ItemVenda item2 = new ItemVenda(feijao, 1);

        // 3️⃣ Criando a venda
        Venda venda = new Venda();
        venda.adicionarItem(item1);
        venda.adicionarItem(item2);

        // 4️⃣ Exibindo o total
        System.out.println("Total da venda: R$ " + venda.calcularTotal());
    }
}
