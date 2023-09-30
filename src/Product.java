// Yo, this here is the VIP pass, the Product class! 🎉
public class Product {

    // Check out these fancy properties every product's gotta have
    private final String ID; // The unique ID - kinda like our student ID, but for products
    private String name; // Product's name, like "Super Cool Sneakers"
    private String description; // A lil' blurb about what's so rad about it
    private double cost; // How much it'll set ya back

    // Constructor time! You feed it details, and it spawns a new product. Magic. ✨
    public Product(String ID, String name, String description, double cost) {
        // "this" just means we're talking about this particular product, not some other random thing
        this.ID = ID; // set the ID
        this.name = name; // set the name
        this.description = description; // set the description
        this.cost = cost; // set the cost
    }

    // Getters - the bouncers that'll fetch you the info you need from our VIP Product
    public String getID() { return ID; } // Gimme the ID!
    public String getName() { return name; } // What's it called?
    public String getDescription() { return description; } // Spill the details!
    public double getCost() { return cost; } // How much is it?

    // Setters - the wizards that'll change the product's info (except the ID, that's sacred 🚫)
    public void setName(String name) { this.name = name; } // Update the name
    public void setDescription(String description) { this.description = description; } // Change the blurb
    public void setCost(double cost) { this.cost = cost; } // Slap on a new price tag

    // This bad boy turns the product's info into a single string, like a secret handshake for databases
    public String toCSVDataRecord() {
        // Join the details together with commas so it looks neat and tidy
        return String.join(", ", ID, name, description, String.valueOf(cost));
    }
}
