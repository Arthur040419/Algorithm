package shuzimali;

import java.util.Arrays;
import java.util.Scanner;

//将字符串转换成驼峰格式
public class Main2 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] split = input.split("-");

        boolean isStart = false;
        StringBuilder res = new StringBuilder();
        for (String s : split) {
            if("".equals(s)){
                continue;
            }
            if (isStart) {
                res.append(s.replaceFirst(s.substring(0, 1), s.toUpperCase().substring(0, 1)));
            }else {
                res.append(s);
                isStart = true;
            }
        }
        System.out.println(res);
    }


}
