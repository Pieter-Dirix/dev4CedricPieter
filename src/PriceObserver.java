public class PriceObserver implements Observer {
    private Item item;
    private ShoppingList list;

    @Override
    public void update() {
        System.out.printf("The price of %s in %s has changed%n", this.item.getName(), this.list.getName());
    }

    public PriceObserver(Item item, ShoppingList list) {
        this.item = item;
        this.list = list;
    }

    public Item getItem() {
        return item;
    }
}
