public class StockObserver implements Observer{
    private Item item;
    @Override
    public void update() {
        System.out.println("%s is currently out of stock".formatted(item.getName()));
    }

    public StockObserver(Item item) {
        this.item = item;
    }
}
