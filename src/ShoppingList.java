import java.sql.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ShoppingList {
    private String name;
    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<Observer> observers = new ArrayList<Observer>();
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
            addObserver(new ItemObserver(item, this));
            addObserver(new StockObserver(item, this));
        }
        updateTotalCost();
    }

    public String getDateCreatedFormatted() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm");
        return formatter.format(this.dateCreated);
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

    public void finishList() {
        this.finished = true;
    }

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void warnObservers(Item item) {

        for (Observer ob : observers) {
            if (item.isUpdated()) {
                if(item.getState() == ItemState.OUT_OF_STOCK) {
                    if (ob instanceof StockObserver) {
                        if (((StockObserver) ob).getItem().getName() == item.getName()) {
                            ob.update();
                        }
                    }
                } else if (item.getPrevPrice() != item.getPrice() && item.getState() != ItemState.OUT_OF_STOCK) {
                    if (ob instanceof ItemObserver) {
                        if (((ItemObserver) ob).getItem().getName() == item.getName()) {
                            ob.update();
                        }
                    }
                }
            }
        }
    }
}
