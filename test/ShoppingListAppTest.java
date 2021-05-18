import org.junit.Test;

import static org.junit.Assert.*;

public class ShoppingListAppTest {
    @Test
    public void  addRetrieveAndIterateShoppingListApp(){
        ShoppingListApp shoppingListApp = new ShoppingListApp();
        ShopItem melk = new ShopItem("Melk",0.99,100);
        ShopItem appels = new ShopItem("Appels",2.99,500);
        ShopItem bananen = new ShopItem("Bananen",1.99,50);
        shoppingListApp.add(melk);
        shoppingListApp.add(appels);
        shoppingListApp.add(bananen);
        for(ShopItem shopItem: shoppingListApp)
            System.err.println(shopItem);

    }


}