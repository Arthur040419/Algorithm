package meituan2025;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //字符串长度
        int len = 0;
        for (int i = 0; i < t; i++) {
            len =sc.nextInt();
            //换行
            sc.nextLine();
            String s = sc.nextLine();
            //字符串中的元素
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            int count = 0;
            int index= 0;
            for (int j = 0; j < len; j++) {
                if(s.charAt(j)!=chars[index]){
                    count++;
                }
                index++;
            }
            if(count!=2){
                System.out.println("NO");
            }else {
                System.out.println("YES");
            }
        }

    }
}
