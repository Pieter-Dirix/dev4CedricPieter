import java.util.ArrayList;
import java.util.Date;

public class ShoppingList {

    private ArrayList<Item> items = new ArrayList<Item>();
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    private Date dateCreated;
    private float totalCost;
    private boolean finished;

    public void addItem(Item item) {
        if(!finished) {
            this.items.add(item);
            addObserver(new ItemObserver(item));
            addObserver(new StockObserver(item));
        }

    }

    public float updateTotalCost() {
        float total = 0;
        for (Item item : items) {
            if (item.getState() != ItemState.OUT_OF_STOCK) {
                total += item.getPrice();
            }
        }
        this.totalCost = total;
        return this.totalCost;
    }

    public void finishList() {
        this.finished = true;
    }

    public void addObserver (Observer observer) {
        this.observers.add(observer);
    }

    public void warnObservers(Item item, ItemState s) {
        for (Observer ob : observers) {
            if(s == ItemState.IN_STOCK) {
                if (ob instanceof ItemObserver) {
                    if (((ItemObserver) ob).getItem().getName() == item.getName()) {
                        ob.update();
                    }
                }
            } else if (s == ItemState.OUT_OF_STOCK) {
                if (ob instanceof StockObserver) {
                        ob.update();
                }
            }

        }
    }
}
