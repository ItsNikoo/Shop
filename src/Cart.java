import java.util.HashMap;
import java.util.Map;

public class Cart {
    protected Map<Product, Integer> cart = new HashMap<>();

    public void addToCart(Product product, int amount) {
        /*
        int actualAmount = storage.getAccountingOfGoods().get(product.getTitle());
        storage.getAccountingOfGoods().put(product, actualAmount - amount);
        */
        cart.put(product, amount);
    }

    public void removeProduct(Product product, int amount) {
        int amountNow = cart.get(product);
        cart.replace(product, amountNow - amount);
    }

    public Map<Product, Integer> getCart() {
        return this.cart;
    }

    public void showCart() {
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            Product product = entry.getKey();
            int amount = entry.getValue();
            System.out.printf("Product: %s, Amount: %d%n", product.getTitle(), amount);
        }
    }
}
