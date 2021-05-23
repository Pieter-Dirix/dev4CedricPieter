public class PriceObserver implements Observer {
    private Item item;
    private ShoppingList list;

    @Override
    public void update() {
        String iName = item.getName();
        String lName = list.getName();
        System.out.printf("The price of %s in %s has changed%n", iName, lName);
    }

    public PriceObserver(Item item, ShoppingList list) {
        this.item = item;
        this.list = list;
    }

    public Item getItem() {
        return item;
    }
}
