package xiecheng2026_03;

import java.util.Scanner;

//携程26届秋招笔试第三批
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int tmp = n;
        int sum = 0;
        while (tmp!=0){
            int i = tmp%10;
            tmp/=10;
            sum+=(int)Math.pow(i,3);
        }
        if (sum==n){
            System.out.println("YES");
            return;
        }
        System.out.println("NO");
    }


}
