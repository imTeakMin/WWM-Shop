package clothes_categories;

import java.util.ArrayList;

public class Item {
    protected String name;
    protected int price;
    protected String explain;
    protected String gender;
    protected String brand;
    // 계절 4개 중에 가변적으로 추가해야됌.
    protected ArrayList<String> season = new ArrayList<>();

    public Item(String name, int price, String explain, String gender, String brand){
        this.name = name;
        this.price = price;
        this.explain = explain;
        this.gender = gender;
        this.brand = brand;
        // 일단 사계절 용으로 만들어야됌.
        season.add("사계절");
    }

    public boolean addSeason(String a){
        String[] arr = a.split(" ");
        if(arr.length > 4){
            return false;
        }
        int check = 0;
        for(int i = 0; i <arr.length; i++){
            switch(arr[i]){
                case "봄":
                    check++;
                    season.remove("사계절");
                    season.add("봄");
                    break;
                case "여름":
                    season.remove("사계절");
                    check++;
                    season.add("여름");
                    break;
                case "가을":
                    season.remove("사계절");
                    check++;
                    season.add("가을");
                    break;
                case "겨울":
                    season.remove("사계절");
                    check++;
                    season.add("겨울");
                    break;
            }
        }
        return check != 0;
    }






}
