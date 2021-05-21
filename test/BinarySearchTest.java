import org.junit.Test;

public class BinarySearchTest {

    @Test
    public void searchForItemByName() {
        ShoppingListApp shoppingListApp = new ShoppingListApp();

        ShoppingList testLijst = new ShoppingList("test lijst");

        for (Item i : BinarySearchNameOfItems.searchForItemByName(shoppingListApp.getAllAvailableItems(), "Bos")
        ) {
            testLijst.addItem(shoppingListApp.find(i.getName()));
        }

        shoppingListApp.addNewShoppingList(testLijst);

        for (Item i :
                testLijst.getItems()) {
            System.out.println(i);
        }


    }
}
