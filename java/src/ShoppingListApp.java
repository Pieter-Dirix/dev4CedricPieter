import java.util.*;

public class ShoppingListApp implements Iterable<Item> {
    // List of all available items
    private TreeMap<String, Item> allAvailableItems;
    // List of all available lists
    private ArrayList<ShoppingList> allShoppingLists = new ArrayList<>();


//    public static void main(String[] args) {
//        ShoppingListApp shoppingListApp = new ShoppingListApp();
//
//    }


    public ShoppingListApp() {
        allAvailableItems = new TreeMap<>();
        populateListOfItems();
        // only runs once in a test instead of every minute, calling it once manually in test
        // fetchNewItemInfo();
    }

    public void add(Item shopItem) {
        allAvailableItems.put(shopItem.getName(), shopItem);
    }

    public Item find(String name) {
        return allAvailableItems.get(name);
    }

    public void addNewShoppingList(ShoppingList list) {
        allShoppingLists.add(list);
        System.out.printf("%s current total cost is %s%n", list.getName(), list.updateTotalCost());
    }

    // Creates all availabe items to choose from
    private void populateListOfItems() {
        Item melk = new Item("Melk", 1, 100);
        Item appels = new Item("Appels", 3, 500);
        Item bananen = new Item("Bananen", 2, 50);
        Item kipFilet = new Item("Kip Filet", 7, 90);
        Item gehakt = new Item("Gehakt", 3.74, 15);
        Item wafels = new Item("Wafels", 2.69, 150);
        Item ham = new Item("Ham", 7, 75);
        Item eieren = new Item("Eieren", 2, 24);
        Item brood = new Item("Wafels", 2.69, 150);
        Item ravioli = new Item("Ravioli", 2.99, 254);
        Item bosbessen = new Item("Bosbessen", 4.09, 113);
        Item bosbessenMuffin = new Item("Bosbessen Muffin", 2, 10);
        Item yoghurt = new Item("Yoghurt", 0.95, 123);
        Item pannenkoeken = new Item("Pannenkoeken", 1.50, 543);
        Item zalm = new Item("Zalm", 3.49, 155);
        Item mais = new Item("Maïs", 2.99, 711);
        Item sinaasappels = new Item("Sinaasappels", 2.39, 234);
        Item tomaten = new Item("Tomaten", 2.59, 153);

        add(melk);
        add(appels);
        add(bananen);
        add(kipFilet);
        add(gehakt);
        add(wafels);
        add(ham);
        add(eieren);
        add(brood);
        add(ravioli);
        add(bosbessen);
        add(yoghurt);
        add(pannenkoeken);
        add(zalm);
        add(mais);
        add(sinaasappels);
        add(tomaten);
        add(bosbessenMuffin);

    }

    // "Fetches" new info for all the items by randomizing the price and stock
    // https://www.codegrepper.com/code-examples/java/java+repeat+function+every+minute
    public void fetchNewItemInfo() {
        Timer timer = new Timer();
        TimerTask fetchItems = new TimerTask() {
            @Override
            public void run() {
                updateItemsWithRandomValues();
            }
        };

        timer.scheduleAtFixedRate(fetchItems, 0l, (60 * 1000));
    }

    // Changes the price and stock of the available items by chance
    private void updateItemsWithRandomValues() {
        for (Map.Entry<String, Item> set : allAvailableItems.entrySet()) {
            // Start with previous price and stock
            Item item = set.getValue();
            double newPrice = item.getPrice();
            int newStock = item.getStock();

            double priceChance = Math.random();
            // Decide if the price should change
            if (priceChance < 0.5) {
                // 50% chance the stock will get lowered by 15
                if (Math.random() < 0.5) {
                    double s = newPrice - 0.15;
                    if (s <= 0.50) {
                        newPrice = 0.50;
                    } else {
                        newPrice = s;
                    }
                } else {
                    newPrice += 0.30;
                }
            }

            // Decide if the stock should change
            double stockChance = Math.random();
            // 10% chance the stock will be zero
            if (stockChance > 0.9) {
                newStock = 0;
                // 50% chance the stock will get lowered by 15
            } else if (stockChance < 0.5) {
                if (Math.random() < 0.5) {
                    int s = item.getStock() - 15;
                    if (s <= 0) {
                        newStock = 0;
                    } else {
                        newStock = s;
                    }
                } else {
                    newStock = item.getStock() + 15;
                }
            }
            item.updateItem(newPrice, newStock);
        }

        loopOverAllListsAndUpdateTotalCost();
    }

    // Updates the total cost of a list and warns observers if necessary
    private void loopOverAllListsAndUpdateTotalCost() {
        if (!(allShoppingLists.size() == 0)) {
            for (ShoppingList list : allShoppingLists) {
                for (Item item : list.getItems()) {
                    if (item.isUpdated()) {
                        list.warnObservers(item);

                        item.setUpdated(false);
                    }
                }
                list.updateTotalCost();
                System.out.printf("%s current total cost is %s%n", list.getName(), list.updateTotalCost());
            }
        }
    }


    public ArrayList<ShoppingList> getAllShoppingLists() {
        return allShoppingLists;
    }

    public TreeMap<String, Item> getAllAvailableItems() {
        return allAvailableItems;
    }

    @Override
    public Iterator<Item> iterator() {
        return allAvailableItems.values().iterator();
    }


}
