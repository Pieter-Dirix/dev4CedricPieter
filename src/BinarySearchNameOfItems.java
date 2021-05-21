import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeMap;

public class BinarySearchNameOfItems {

    public static ArrayList<Item> searchForItemByName(TreeMap<String, Item> allItems, String itemName) {
        ArrayList<Item> searchResults = new ArrayList<>();
        // treemap to arraylist
        // https://www.javacodeexamples.com/convert-treemap-to-arraylist-in-java-example/2648
        Collection<Item> tempItems = allItems.values();
        ArrayList<Item> items = new ArrayList<>(tempItems);

        int low = 0;
        int high = allItems.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            Item guess = items.get(mid);
            if (guess.getName().contains(itemName)) {
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