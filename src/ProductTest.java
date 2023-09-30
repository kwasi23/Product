// Yo dude, you know how we have to "assert" stuff in tests? I got those imports on lock:
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Check it, this is the big-league test for our Product class:
public class ProductTest {

    // Just throwing in a placeholder for our soon-to-be product. Keep that seat warm!
    Product product;

    // You know that pre-game ritual before a big party? That's what this is:
    @BeforeEach
    public void setUp() {
        // Popping open a brand new "Cool Gadget" from the box before each test:
        product = new Product("001", "Cool Gadget", "A gadget that's cool.", 29.99);
    }

    // Gonna test if that constructor is doing its thing:
    @Test
    public void testConstructor() {
        // Making sure our product has the right ID, name, description, and cost.
        // If not, then our constructor's on thin ice, man.
        assertEquals("001", product.getID());
        assertEquals("Cool Gadget", product.getName());
        assertEquals("A gadget that's cool.", product.getDescription());
        assertEquals(29.99, product.getCost());
    }

    // Let's check if our product's data can throw down in CSV style:
    @Test
    public void testToCSVDataRecord() {
        // Setting the vibe of what our CSV should look like:
        String expectedCSV = "001, Cool Gadget, A gadget that's cool., 29.99";
        // If our product doesn't match the vibe, we've got a problem:
        assertEquals(expectedCSV, product.toCSVDataRecord());
    }

}

