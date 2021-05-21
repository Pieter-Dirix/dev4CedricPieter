import java.lang.reflect.Constructor;

public class Item {

    private ItemState state = ItemState.OUT_OF_STOCK;
    private String name;
    private double price;
    private double prevPrice;
    private int stock;
    private int prevStock;
    private boolean updated;

    public Item(String name,  double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.updated = false;
        if (stock == 0 ) {
            this.state = ItemState.OUT_OF_STOCK;
        } else {
            this.state = ItemState.IN_STOCK;
        }
    }

    // Updates the item's price and stock, while keeping track of their previous values
    public void updateItem(double price, int stock) {
        this.prevPrice = this.price;
        this.prevStock = this.stock;

        this.price = price;

        if (stock == 0) {
            this.state = ItemState.OUT_OF_STOCK;
        }
        this.stock = stock;

        // Keep track if the item is updated or not, so we can check this later
        if(this.prevStock != stock || this.prevPrice != price) {
            this.updated = true;
        }
    }

    public int getStock() {
        return stock;
    }

    public ItemState getState() {
        return state;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public boolean isUpdated() {
        return updated;
    }

    public void setUpdated(boolean updated) {
        this.updated = updated;
    }

    public double getPrevPrice() {
        return prevPrice;
    }

    @Override
    public String toString (){
        return name + " €" + price + " "+ stock + " artikelen "+ "op voorraad";
    }

}
