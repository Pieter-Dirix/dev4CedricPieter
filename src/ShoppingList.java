import java.util.ArrayList;
import java.util.Date;

public class ShoppingList {
    private String name;
    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<Observer> observers = new ArrayList<>();
    private Date dateCreated;
    private double totalCost;
    private boolean finished;

    public ShoppingList(String name) {
        this.name = name;
        this.dateCreated = new Date(System.currentTimeMillis());
    }

    public void addItem(Item item) {
        if (!finished) {
            this.items.add(item);
            addObserver(new PriceObserver(item, this));
            addObserver(new StockObserver(item, this));
        }
        updateTotalCost();
    }

    public double updateTotalCost() {
        double total = 0;
        for (Item item : items) {
            if (item.getState() != ItemState.OUT_OF_STOCK) {
                total += item.getPrice();
            }
        }
        this.totalCost = total;
        return this.totalCost;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void warnObservers(Item item) {

        if (item.isUpdated()) {
            for (Observer ob : observers) {
                // If item is out of stock, notify the StockObserver so it can send an alert (print to console)
                if (item.getState() == ItemState.OUT_OF_STOCK) {
                    if (ob instanceof StockObserver) {
                        if (((StockObserver) ob).getItem().getName().equals(item.getName())) {
                            ob.update();
                        }
                    }
                // If the item's price has changed and is still in stock, notify the PriceObserver so it can send an alert (print to console)
                } else if (item.getPrevPrice() != item.getPrice() && item.getState() != ItemState.OUT_OF_STOCK) {
                    if (ob instanceof PriceObserver) {
                        if (((PriceObserver) ob).getItem().getName().equals(item.getName())) {
                            ob.update();
                        }
                    }
                }
            }
        }
    }
}
