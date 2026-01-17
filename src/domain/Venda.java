package domain;

import java.util.ArrayList;
import java.util.List;

public class Venda {

    private List<ItemVenda> itens;

    public Venda() {
        this.itens = new ArrayList<>();
    }

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

    public List<ItemVenda> getItens() {
        return itens;
    }
}

