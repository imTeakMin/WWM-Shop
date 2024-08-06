package clothes_categories.bottom;

import clothes_categories.Item;

public class Bottom extends Item {
    int size;
    public Bottom(String name, int price, String ex, String gender, String brand, int size){
        super(name,price,ex,gender,brand);
        this.size = size;
    }

    public void getBottom(String a, int b, String c, String d, String e, int f){
        this.name = a;
        this.price = b;
        this.explain = c;
        this.gender = d;
        this.brand = e;
        this.size = f;
    }
}
