public class ItemObserver implements Observer {
    private Item item;
    private ShoppingList list;

    @Override
    public void update() {
        System.out.println(String.format("The price of %s in %s has changed", this.item.getName(), this.list.getName()));
    }

    public ItemObserver(Item item, ShoppingList list) {
        this.item = item;
        this.list = list;
    }

    public Item getItem() {
        return item;
    }
}
