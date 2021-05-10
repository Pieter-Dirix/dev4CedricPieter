public class Item {
    private String name;
    private String description;
    private int state;
    private float price;
    private int stock;

    public Item(String name, String description, int state, float price, int stock){
        this.name = name;
        this.description = description;
        this.state = state;
        this.price = price;
        this.stock = stock;
    }

    public String toString(){return name + " " + description;}

    public String getName(){return name;}boolean equals (Object o){
        if (this == o) return true;
        if (!(o instanceof ShoppingListApp)) return false;
        Item item = (Item) o;
        return description == item.description && getName().equals(item.getName());
    }


}
