package domain;

import java.util.ArrayList;
import java.util.List;

public class Venda {

    private List<ItemVenda> itens = new ArrayList<>();

    public void adicionarItem(ItemVenda item) {
        itens.add(item);
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemVenda item : itens) {
            total += item.calcularSubtotal();
        }
        return total;
    }

    public void imprimirResumo() {
        System.out.println("=== RESUMO DA VENDA ===");

        for (ItemVenda item : itens) {
            System.out.printf("- %s: R$ %.2f%n",
                    item.getProduto().getNome(),
                    item.calcularSubtotal());
        }

        System.out.printf("TOTAL: R$ %.2f%n", calcularTotal());
    }
}


