
import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

import clothes_categories.accessories.*;
import clothes_categories.bottom.*;
import clothes_categories.shoes.*;
import clothes_categories.top.*;

public class RUN {
    public static boolean createProduct() {
        Scanner s = new Scanner(System.in);
        String category, name, explain, gender, brand, season;
        int size;
        int price = 0;
        System.out.println("-----등록하실 제품-----");
        System.out.print("카테고리: ");
        category = s.nextLine();
        category = category.toUpperCase();
        switch (category) {
            case "SHOES", "신발" -> {
                Shoes shoes = new Shoes("NULL", 0, "NULL", "NULL", "NULL", 0);
                System.out.print("상품명: ");
                name = s.nextLine();
                // 가격 예외처리.
                while (true) {
                    System.out.print("가격: ");
                    try {
                        price = s.nextInt();
                        s.nextLine();
                    } catch (InputMismatchException i) {
                        System.out.println("수만 입력해주세요.");
                        return false;
                    }
                    if (price < 10 || price > 100_000_000) {
                        System.out.println("가격은 10원 ~ 100,000,000원 사이로 입력해주세요.");
                    } else break;
                }
                System.out.print("설명: ");
                explain = s.nextLine();
                System.out.print("성별: ");
                gender = s.nextLine();
                // 성별 예외처리 후 데이터 정리.

                System.out.print("브랜드: ");
                brand = s.nextLine();
                System.out.print("사이즈: ");
                size = s.nextInt();
                s.nextLine();
                // 사이즈 예외처리 후 데이터 정리.

                while (true) {
                    System.out.print("계절: ");
                    season = s.nextLine();
                    shoes.getShoes(name, price, explain, gender, brand, size);
                    if (!shoes.addSeason(season)) {
                        System.out.println("계절 입력 오류. 다시 입력해주세요.");
                    } else break;
                }
                shoes.toString();
            }
            case "TOP", "상의" -> {
                Top top = new Top("NULL", 0, "NULL", "NULL", "NULL", 0);
                System.out.print("상품명: ");
                name = s.nextLine();
                System.out.print("가격: ");
                price = s.nextInt();
                s.nextLine();
                System.out.print("설명: ");
                explain = s.nextLine();
                System.out.print("성별: ");
                gender = s.nextLine();
                System.out.print("브랜드: ");
                brand = s.nextLine();
                System.out.print("사이즈: ");
                size = s.nextInt();
                s.nextLine();
                top.getTop(name, price, explain, gender, brand, size);
            }
            case "BOTTOM", "하의" -> {
                Bottom bottom = new Bottom("NULL", 0, "NULL", "NULL", "NULL", 0);
                System.out.print("상품명: ");
                name = s.nextLine();
                System.out.print("가격: ");
                price = s.nextInt();
                s.nextLine();
                System.out.print("설명: ");
                explain = s.nextLine();
                System.out.print("성별: ");
                gender = s.nextLine();
                System.out.print("브랜드: ");
                brand = s.nextLine();
                System.out.print("사이즈: ");
                size = s.nextInt();
                s.nextLine();
                bottom.getBottom(name, price, explain, gender, brand, size);
            }
            case "ACCESSORIES", "악세사리" -> {
                Accessories accessories = new Accessories("NULL", 0, "NULL", "NULL", "NULL");
                System.out.print("상품명: ");
                name = s.nextLine();
                System.out.print("가격: ");
                price = s.nextInt();
                s.nextLine();
                System.out.print("설명: ");
                explain = s.nextLine();
                System.out.print("성별: ");
                gender = s.nextLine();
                System.out.print("브랜드: ");
                brand = s.nextLine();
                accessories.getAccessories(name, price, explain, gender, brand);
            }
            default -> {
                System.out.println("카테고리 입력오류.");
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(createProduct());




    }
}
