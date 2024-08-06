package clothes_categories.accessories;

import clothes_categories.Item;

public class Accessories extends Item {
    public Accessories(String name, int price, String ex, String gender, String brand){
        super(name,price,ex,gender,brand);
    }

    public void getAccessories(String a, int b, String c, String d, String e){
        this.name = a;
        this.price = b;
        this.explain = c;
        this.gender = d;
        this.brand = e;
    }
}
