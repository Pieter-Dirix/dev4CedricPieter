import java.lang.reflect.Constructor;

public class Item {

    private ItemState state = ItemState.OUT_OF_STOCK;
    private String name;
    private String description;
    private double price;
    private int stock;

    public Item(String name, String description, double price, int stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        if (stock == 0 ) {
            this.state = ItemState.OUT_OF_STOCK;
        } else {
            this.state = ItemState.IN_STOCK;
        }
    }


    public void updateItem(Item item) {
        this.price = item.price;

        if (item.stock == 0) {
            this.state = ItemState.OUT_OF_STOCK;
        }
        this.stock = item.stock;
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

    @Override
    public String toString (){
        return name + " €" + price + " "+ stock + " artikelen "+ "op voorraad";
    }

}
