import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        Map<Product, Integer> storage = new HashMap<>();

        Storage accountingOfGoods = new Storage(storage);

        Product latte = new Product("Latte", 249);
        Product latte_with_raspberry = new Product("Latte with Rapsberry", 309);

        products.add(latte);
        accountingOfGoods.setGood(latte,5);
        products.add(latte_with_raspberry);
        accountingOfGoods.setGood(latte_with_raspberry,3);
        accountingOfGoods.showAccountingOfGoods();
        System.out.println("");
        Shop prime = new Shop(products);
        prime.showProducts();
        System.out.println("");

        Cart myCart = new Cart();
        myCart.addToCart(latte,20);
        myCart.showCart();
        Order myOrder = new Order(myCart.getCart());
        myOrder.makeOrder(accountingOfGoods);
        accountingOfGoods.showAccountingOfGoods();
    }
}