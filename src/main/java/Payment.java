import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Payment {
    private double cartPrice;
    private ArrayList<Product> products;
    private Scanner scanner;

    class Product {
        private double productPrice;
        private String name;

        public Product(String name, double productPrice) {
            this.name = name;
            if (productPrice > 0) {
                this.productPrice = productPrice;
            } else {
                productPrice = 0;
            }
        }

        public double getProductPrice() {
            return productPrice;
        }

        public String getName() {
            return name;
        }

        public void setProductPrice(double productPrice) {
            if (productPrice > 0) {
                this.productPrice = productPrice;
            } else {
                productPrice = 0;
            }
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public Payment() {
        cartPrice = 0;
        scanner = new Scanner(System.in);
        products = new ArrayList<>();
    }

    public void addProduct() throws IOException {
        try {
                System.out.println("Товар:");
                System.out.print("Наименование: ");
                String productName = scanner.next();
                System.out.print("Цена: ");
                double productCost = scanner.nextDouble();
                products.add(new Product(productName, productCost));
        } catch(NumberFormatException e) {
            System.out.println("Неверный формат");
        } catch(NegativeArraySizeException e) {
            System.out.println("Количество покупок не может быть меньше 0");
        }
        refreshCartPrice();
    }

    public void addProduct(Product product) {
        products.add(product);
        refreshCartPrice();
    }

    private void refreshCartPrice() {
        if (products.size() == 0) {
            cartPrice = 0;
        } else {
            cartPrice = 0;
            for (Product product: products) {
                cartPrice += product.getProductPrice();
            }
        }
    }

    public double getCartPrice() {
        refreshCartPrice();
        return cartPrice;
    }
}
