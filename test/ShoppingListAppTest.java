import org.junit.Test;

public class ShoppingListAppTest {

    @Test
    public void fetchNewItemsAndWarnObserversIfNecessary() {
        ShoppingListApp shoppingListApp = new ShoppingListApp();

        ShoppingList testLijst = new ShoppingList("test lijst");

        testLijst.addItem(shoppingListApp.find("Melk"));
        testLijst.addItem(shoppingListApp.find("Appels"));
        testLijst.addItem(shoppingListApp.find("Bananen"));

        shoppingListApp.addNewShoppingList(testLijst);

        //Replacement for the timer since those don't seem to work in tests
        shoppingListApp.fetchNewItemInfo();


    }


}