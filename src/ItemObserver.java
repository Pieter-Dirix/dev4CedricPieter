public class ItemObserver implements Observer {
    private Item item;

    @Override
    public void update() {
        System.out.println(this.item.getName() + " has changed");
    }

    public ItemObserver(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }
}
