import java.util.ArrayList;
import java.util.Iterator;

public class BinarySearchNameOfItems {

    //Method for retrieving a list of items of which their name matches the given input (eg. search box)
    public static ArrayList<Item> searchForItemByName(String itemName, ShoppingListApp app) {
        ArrayList<Item> searchResults = new ArrayList<>();

        // Using the iterator, create a arraylist with all the items to use later

        ArrayList<Item> items = new ArrayList<>();
        Iterator<Item> itr = app.iterator();

        while (itr.hasNext()){
            Item item = itr.next();
            items.add(item);
        }

        int low = 0;
        int high = items.size() - 1;

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
