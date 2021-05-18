import org.junit.Test;

import static org.junit.Assert.*;

public class ShoppingListAppTest {
    @Test
    public void  addRetrieveAndIterateShoppingListApp(){
        ShoppingListApp shoppingListApp = new ShoppingListApp();
        Item melk = new Item("Melk", "Melk van een koe", 0.99, 100);
        Item appels = new Item("Appels","Jonagolden, deze keer wel bijgevuld",2.99,500);
        Item bananen = new Item("Bananen","De beste van Chiquita", 1.99,50);
        shoppingListApp.add(melk);
        shoppingListApp.add(appels);
        shoppingListApp.add(bananen);
        for(Item shopItem: shoppingListApp)
            System.err.println(shopItem);

    }


}