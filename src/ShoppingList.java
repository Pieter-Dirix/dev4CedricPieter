import java.util.ArrayList;
import java.util.Date;

public class ShoppingList {

    private ArrayList<Item> items = new ArrayList<Item>();
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    private Date dateCreated;
    private float totalCost;
    private boolean finished;

    public void addItem(Item item) {
        this.items.add(item);
        this.observers.add(new ItemObserver(item));
    }

    public float updateTotal() {
        float total = 0;
        for (Item item : items) {
            if (item.getState() != ItemState.OUT_OF_STOCK) {
                total += item.getPrice();
            }
        }
        return total;
    }

    public void warnObservers(Item item) {
        for (Observer ob : observers) {
            if (ob instanceof ItemObserver) {
                if (((ItemObserver) ob).getItem().getName() == item.getName()) {
                    ob.update();
                }
            }
        }
    }
}
