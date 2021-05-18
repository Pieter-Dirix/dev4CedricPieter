import java.util.*;

public class ShoppingListApp implements Iterable<Item> {
    private Map<String, Item> shoppingListApp;

    public ShoppingListApp() {
        shoppingListApp = new HashMap<>();
    }

    public void add(Item shopItem) {
        shoppingListApp.put(shopItem.getName(), shopItem);
    }

    public Item find(String name) {
        return shoppingListApp.get(name);
    }

    /*public List<Person> getPersons() {
        return people.values();
    }*/

    @Override
    public Iterator<Item> iterator() {
        return shoppingListApp.values().iterator();
    }



}
