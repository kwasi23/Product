// Importing the squad (libraries we need)
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ProductGenerator {

    public static void main(String[] args) {
        // Cranking up the old scanner to read from the console
        Scanner sc = new Scanner(System.in);
        // Prepping an empty party list for our products
        List<Product> products = new ArrayList<>();

        // 'answer' is like that annoying friend who keeps asking if we wanna go another round
        String answer;
        do {
            System.out.println("Craft a new product!"); // Popping the big question: What's the new product?
            // Generating a unique party ID for our product - no two products crash into each other
            String ID = UUID.randomUUID().toString();
            // Using the cool 'SafeInput' utility to grab the product name and avoid any mishaps
            String name = SafeInput.getString(sc, "Product Name");
            // Ditto, but for the product's description
            String description = SafeInput.getString(sc, "Description");
            // Getting the product's cost but making sure it's somewhere between 0 and a whopping 10k
            double cost = SafeInput.getRangedDouble(sc, "Cost", 0, 10000);

            // Adding our fresh product to the list. Welcome to the party, pal!
            products.add(new Product(ID, name, description, cost));

            // Asking the big question: Another round?
            System.out.println("Add another product? (yes/no)");
            answer = sc.nextLine(); // Listen to the decision
        } while (answer.equalsIgnoreCase("yes")); // Keep the party going as long as they say 'yes'

        // Time to immortalize the party list in a file named 'products.csv'
        Path file = Paths.get("products.csv");
        try (BufferedWriter writer = Files.newBufferedWriter(file, StandardOpenOption.CREATE)) {
            // For every product in our list
            for (Product product : products) {
                // Write that bad boy's details to the file in CSV format
                writer.write(product.toCSVDataRecord());
                writer.newLine(); // Move to the next line for the next product
            }
            // Tell the user the good news: The party list is saved!
            System.out.println("Products saved to 'products.csv'.");
        } catch (IOException ex) {
            // Uh-oh, we hit a snag. Time to let the user know something went south.
            System.out.println("Error writing to file.");
            ex.printStackTrace(); // Dump the stack trace for any nerds looking at the console
        }
    }
}
