
public class StockObserver implements Observer {
    private Item item;
    private ShoppingList list;

    @Override
    public void update() {
        String iName = item.getName();
        String lName = list.getName();

        System.out.printf("%s in %s is currently out of stock%n", iName, lName);
    }

    public StockObserver(Item item, ShoppingList list) {
        this.item = item;
        this.list = list;
    }

    public Item getItem() {
        return item;
    }
}
