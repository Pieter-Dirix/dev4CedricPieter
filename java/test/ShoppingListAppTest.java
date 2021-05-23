
import org.junit.jupiter.api.*;

public class ShoppingListAppTest {

    private static ShoppingListApp shoppingListApp;

    // instantiate the app and add lists with items
    @BeforeAll
    public static void setUp() {
        shoppingListApp  = new ShoppingListApp();

        ShoppingList lijstNummerEen = new ShoppingList("Nummer één");

        lijstNummerEen.addItem(shoppingListApp.find("Melk"));
        lijstNummerEen.addItem(shoppingListApp.find("Appels"));
        lijstNummerEen.addItem(shoppingListApp.find("Bananen"));

        shoppingListApp.addNewShoppingList(lijstNummerEen);


        ShoppingList lijstNummerTwee = new ShoppingList("Nummer twee");

        lijstNummerTwee.addItem(shoppingListApp.find("Kip Filet"));
        lijstNummerTwee.addItem(shoppingListApp.find("Gehakt"));
        lijstNummerTwee.addItem(shoppingListApp.find("Eieren"));
        lijstNummerTwee.addItem(shoppingListApp.find("Zalm"));
        lijstNummerTwee.addItem(shoppingListApp.find("Ravioli"));

        shoppingListApp.addNewShoppingList(lijstNummerTwee);

        System.out.println("=======================");
    }

    // Updates all items and warns observers
    @RepeatedTest(3)
    public void testCreatingNewListsAndWarningObserversIfItemsChange() {
        shoppingListApp.fetchNewItemInfo();
    }
}