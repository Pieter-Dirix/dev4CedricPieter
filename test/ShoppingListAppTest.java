import org.junit.Test;

import static org.junit.Assert.*;

public class ShoppingListAppTest {
    @Test
    void addRetrieveAndIterateShoppingListApp(){
        ShoppingListApp shoppingListApp = new ShoppingListApp();
        ShopItem melk = new ShopItem("Melk",0.99,100);
        shoppingListApp.add(melk);
        for(ShopItem shopItem: shoppingListApp)
            System.err.println(shopItem);

        ShopItem[] expected = new ShopItem[]{ new ShopItem("Melk", 0.99, 100),
                new ShopItem("ei",1.00,200),
                new ShopItem("banaan",1.99,50)

        };
    }


}