import java.lang.reflect.Constructor;

public class Item {
    final static int IN_STOCK = 0;
    final static int OUT_OF_STOCK = 1;

    private int state = IN_STOCK;
    private String name;
    private String description;
    private float price;
    private int stock;

    public Item(String name, String description, float price, int stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        if (stock == 0 ) {
            this.state = OUT_OF_STOCK;
        } else {
            this.state = IN_STOCK;
        }
    }

    public void updateItem(Item item) {
        this.price = item.price;

        if (item.stock == 0) {
            this.state = OUT_OF_STOCK;
        }
        this.stock = item.stock;
    }
}
