public class StockObserver implements Observer{
    private Item item;
    @Override
    public void update() {
        System.out.println(String.format("%s is currently out of stock", this.item.getName()));
    }

    public StockObserver(Item item) {
        this.item = item;
    }
}
