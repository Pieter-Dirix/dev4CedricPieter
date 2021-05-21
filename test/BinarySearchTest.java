import org.junit.Test;

public class BinarySearchTest {

    // "Search box" to find item by name
    @Test
    public void searchForItemByName() {
        ShoppingListApp shoppingListApp = new ShoppingListApp();
        String input = "Bos";

        ShoppingList testLijst = new ShoppingList("test lijst");

        for (Item i : BinarySearchNameOfItems.searchForItemByName(shoppingListApp.getAllAvailableItems(), input)) {
            // Adds all results in to the shopping list's list of items
            testLijst.addItem(shoppingListApp.find(i.getName()));
        }

        shoppingListApp.addNewShoppingList(testLijst);

        for (Item i : testLijst.getItems()) {
            System.out.println(i);
        }


    }
}
