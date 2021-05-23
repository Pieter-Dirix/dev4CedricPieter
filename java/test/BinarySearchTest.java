import org.junit.Test;
import java.util.ArrayList;

public class BinarySearchTest {

    // "Search box" to find item by name
    @Test
    public void searchForItemByName() {
        ShoppingListApp shoppingListApp = new ShoppingListApp();
        String input = "Bos";

        ArrayList<Item> searchResults = BinarySearchNameOfItems.searchForItemByName(input, shoppingListApp);

        System.out.println("Search results:");
        for (Item i : searchResults) {
            System.out.println(i);
        }


    }
}
