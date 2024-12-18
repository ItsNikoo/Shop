import java.util.HashMap;
import java.util.Map;

public class Order {
    private String id;
    private Map<Product, Integer> accountingOfGoods = new HashMap<>();
    Storage storage = new Storage(accountingOfGoods);
    private Map<Product, Integer> cart = new HashMap<>();

    Order(Map<Product, Integer> items) {
        this.cart = items;
    }

    public boolean makeOrder(Storage storage) {
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            if (!storage.reduceProductQuantity(product, quantity)) {
                System.out.println("Failed to process order due to insufficient stock.");
                return false; // Останавливаем выполнение, если товара не хватает
            }
        }
        return true; // Все товары успешно списаны

    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }


}
