import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

public class BinarySearchNameOfItems {

    //Method for retrieving a list of items of which their name matches the given input (eg. search box)
    public static ArrayList<Item> searchForItemByName(TreeMap<String, Item> allItems, String itemName, ShoppingListApp app) {
        ArrayList<Item> searchResults = new ArrayList<>();

        // treemap to arraylist

        ArrayList<Item> items = new ArrayList<>();
        Iterator itr = app.iterator();

        while (itr.hasNext()){
            Item item = (Item) itr.next();
            items.add(item);
        }

        int low = 0;
        int high = allItems.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            Item guess = items.get(mid);
            if (guess.getName().toLowerCase().contains(itemName.toLowerCase())) {
                searchResults.add(guess);
            }

            if (guess.getName().compareToIgnoreCase(itemName) > 0) {
                high = mid - 1;
            } else if (guess.getName().compareToIgnoreCase(itemName) < 0) {
                low = mid + 1;
            }

        }

        return searchResults;
    }

}
