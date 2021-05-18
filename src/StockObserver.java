<<<<<<< HEAD
public class StockObserver implements Observer{
    private Item item;
    private ShoppingList list;
    @Override
    public void update() {
        System.out.println(String.format("%s in %s is currently out of stock", this.item.getName(), this.list.getName()));
    }

    public StockObserver(Item item, ShoppingList list) {
        this.item = item;
        this.list = list;
    }
=======
public class StockObserver {


>>>>>>> 82e54c0d311a348335f98570910795df23a487d4
}
