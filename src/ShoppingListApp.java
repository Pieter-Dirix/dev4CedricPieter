import java.util.*;

public class ShoppingListApp implements Iterable<Item> {
    private Map<String, Item> allAvailableItems;
    //lijst van shopping lijsten
    private ArrayList<ShoppingList> allShoppingLists = new ArrayList<>();

    public ShoppingListApp() {
        allAvailableItems = new HashMap<>();
        populateListOfItems();
        //only runs once in a test instead of every minute, calling it once manually in test
        //fetchNewItemInfo();
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

    private void populateListOfItems() {
        Item melk = new Item("Melk", "Melk van een koe", 0.99, 100);
        Item appels = new Item("Appels", "Jonagolden, deze keer wel bijgevuld", 2.99, 500);
        Item bananen = new Item("Bananen", "De beste van Chiquita", 1.99, 50);
        add(melk);
        add(appels);
        add(bananen);
    }

    // simuleert items van een api af te halen om de zoveel tijd
    //https://www.codegrepper.com/code-examples/java/java+repeat+function+every+minute
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

    //simuleert eventuele aanpassingen die zouden gebeuren
    public void updateItemsWithRandomValues() {
        for (Map.Entry<String, Item> set : allAvailableItems.entrySet()) {
            //start with previous price and stock
            Item item = set.getValue();
            double newPrice = item.getPrice();
            int newStock = item.getStock();

            double priceChance = Math.random();
            //decide if the price should change
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

            //decide if the stock should change
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

            //System.out.println(item.getName() + " " + newPrice + " " + newStock  );
            item.updateItem(newPrice, newStock);
        }

        loopOverCurrentLists();
    }

    // update de totale prijs en checked of er een item veranderd is => warnobserver
    public void loopOverCurrentLists() {
        if (!(allShoppingLists.size() == 0)) {
            for (ShoppingList list : allShoppingLists) {
                for (Item item : list.getItems()) {
                    if (item.isUpdated()) {
                        // System.out.println(String.format("%s in %s has changed", item.getName(), list.getName()));
                        list.warnObservers(item);
                        list.updateTotalCost();
                        item.setUpdated(false);
                    }
                }
                System.out.printf("%s current total cost is %s%n", list.getName(), list.updateTotalCost());
            }
        }

    }
    //checked om de zoveel tijd of de prijzen en stock aangepast zijn


    public ArrayList<ShoppingList> getAllShoppingLists() {
        return allShoppingLists;
    }

    @Override
    public Iterator<Item> iterator() {
        return allAvailableItems.values().iterator();
    }


}
