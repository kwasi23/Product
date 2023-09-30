import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProductReader {

    private ArrayList<Product> products;
    private final String filePath = "products.csv";  // you can change the path if necessary

    public ProductReader() {
        products = new ArrayList<>();
    }

    public void loadFromCSV() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    String name = data[0];
                    String description = data[1];
                    String id = data[2];
                    double cost = Double.parseDouble(data[3]);
                    products.add(new Product(name, description, id, cost));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayProducts() {
        for (Product product : products) {
            System.out.println("Name: " + product.getName());
            System.out.println("Description: " + product.getDescription());
            System.out.println("ID: " + product.getID());
            System.out.println("Cost: $" + product.getCost());
            System.out.println("----------------------------");
        }
    }

    public static void main(String[] args) {
        ProductReader reader = new ProductReader();
        reader.loadFromCSV();
        reader.displayProducts();
    }
}
