package meituan2025;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //工作天数
        int n = 0;
        int k = 0;
        //工作总时长
        int workTime = 0;
        for (int i = 0; i < t; i++) {
            n = sc.nextInt();
            k = sc.nextInt();
            for (int j = 0; j < n; j++) {
                workTime+=sc.nextInt();
            }
            if(workTime>k*n){
                System.out.println("NO");
            }else {
                System.out.println("YES");
            }
            workTime=0;
        }


    }
}
