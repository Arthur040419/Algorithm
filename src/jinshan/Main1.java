package jinshan;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        BigDecimal res = new BigDecimal((a+b)*9);
        BigDecimal result = res.divide(new BigDecimal(4), 2,RoundingMode.HALF_UP);
        System.out.println(result.toString());
    }

}
