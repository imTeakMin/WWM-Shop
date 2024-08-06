package clothes_categories.shoes;

import clothes_categories.Item;

public class Shoes extends Item {
    int size;
    public Shoes(String name, int price, String ex, String gender, String brand, int size){
        super(name,price,ex,gender,brand);
        this.size = size;
    }

    public void getShoes(String a, int b, String c, String d, String e, int f){
        this.name = a;
        this.price = b;
        this.explain = c;
        this.gender = d;
        this.brand = e;
        this.size = f;
    }



    @Override
    public String toString(){
        System.out.println(name);
        System.out.println(price);
        System.out.println(explain);
        System.out.println(gender);
        System.out.println(brand);
        System.out.println(size);
        for(int i = 0;i<season.size();i++){
            System.out.println(season.toArray()[i]);
        }
        return null;
    }

}
