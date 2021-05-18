import java.awt.*;
import java.util.*;

public class ShoppingListApp implements Iterable<ShopItem> {
    private Map<String, ShopItem> shoppingListApp;

    public ShoppingListApp() {
        shoppingListApp = new HashMap<>();
    }

    public void add(ShopItem shopItem) {
        shoppingListApp.put(shopItem.getName(), shopItem);
    }

    public ShopItem find(String name) {
        return shoppingListApp.get(name);
    }

    /*public List<Person> getPersons() {
        return people.values();
    }*/

    @Override
    public Iterator<ShopItem> iterator() {
        return shoppingListApp.values().iterator();
    }



}
