package yongyou2025_2;

import java.util.Scanner;

public class Main4 {

    static int s = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String[] split = input.split(",");
        String info = split[0];
        double price = Double.valueOf(split[1]);
        int num = Integer.valueOf(split[2]);
        double totalPrice = price * num;

        double lowestPrice = getLowestPrice(price, num);
        //100*lowestPrice / totalPrice结果保留1位小数
        String string = Double.toString(100 * lowestPrice / totalPrice);
        string = string.substring(0, string.indexOf(".") + 2);
        String[] strings = new String[]{"满减促销", "折扣促销", "会员专享"};
        String result = String.format("商品信息: %s, 单价: %s, 数量: %s\n" +
                "原始金额: %s\n" +
                "最优金额: %s\n" +
                "应用促销: %s\n" +
                "节省金额: %s\n" +
                "实付比例: %s", info, (int)price, num, (int)totalPrice, (int)lowestPrice, strings[s], (int)(totalPrice - lowestPrice), string);
        result += "%";
        System.out.println(result);

    }

    public static double getLowestPrice(double price, int num) {
        double lowestPrice = price * num;
        double totalPrice = lowestPrice;
        if (totalPrice >= 300) {
            double tmp = priceReduce(price, num);
            if (lowestPrice > tmp) {
                s = 0;
                lowestPrice = tmp;
            }

        }
        if (price >= 100) {
            double tmp = priceDiscount(price, num);
            if (lowestPrice > tmp) {
                s = 1;
                lowestPrice = tmp;
            }
        }
        if (num >= 5) {
            double tmp = memberDiscount(price, num);
            if (lowestPrice > tmp) {
                s = 2;
                lowestPrice = tmp;
            }
        }
        return lowestPrice;
    }

    //满减促销
    public static double priceReduce(double price, int num) {
        return price * num - 80;
    }

    //折扣促销
    public static double priceDiscount(double price, int num) {
        return price * num * 0.85;
    }

    //会员专享
    public static double memberDiscount(double price, int num) {
        return price * num * 0.75;
    }


}
