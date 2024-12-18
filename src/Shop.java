import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Product> products = new ArrayList();

    Shop(List<Product> prods) {
        this.products = prods;
    }

    public void addProduct(String title, double price) {
        Product prod = new Product(title, price);
        products.add(prod);
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void showProducts() {
        for (Product prod : products) {
            System.out.println("Product: " + prod.getTitle() + " | Price: " + prod.getPrice());
        }
    }
}
