public class ShopItem {
    private String name;
    private double price;
    private int stock;

    public ShopItem(String name, double price, int stock){
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    @Override
    public String  toString (){
        return name + " €" + price + stock + "op voorraad";
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public int getStock(){
        return stock;
    }
}
