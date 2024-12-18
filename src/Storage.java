import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<Product, Integer> accountingOfGoods = new HashMap<>();
    private int key = 0;

    Storage(Map<Product, Integer> goods) {
        this.accountingOfGoods = goods;
    }

    public void setGood(Product product, int amount) {
        accountingOfGoods.putIfAbsent(product, amount);
        key++;
    }

    public Map<Product, Integer> getAccountingOfGoods() {
        return this.accountingOfGoods;
    }

    public boolean reduceProductQuantity(Product product, int quantity) {
        if (!accountingOfGoods.containsKey(product)) {
            System.out.println("Продукт не найден в хранилище!");
            return false;
        }

        int currentQuantity = accountingOfGoods.get(product);
        if (currentQuantity < quantity) {
            System.out.println("Не хватает продукта: " + product.getTitle());
            return false;
        }

        accountingOfGoods.put(product, currentQuantity - quantity);
        return true;
    }


    public void showAccountingOfGoods() {
        for (Map.Entry<Product, Integer> entry : accountingOfGoods.entrySet()) {
            Product product = entry.getKey();
            int amount = entry.getValue();
            System.out.printf("Product: %s, Amount: %d%n", product.getTitle(), amount);
        }
    }
}
