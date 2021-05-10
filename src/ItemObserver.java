public class ItemObserver implements Observer {
    private Item item;

    @Override
    public void update() {
        System.out.println(String.format("The price of %s has changed", this.item.getName()));
    }

    public ItemObserver(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }
}
