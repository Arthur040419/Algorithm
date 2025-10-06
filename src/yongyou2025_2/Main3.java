package yongyou2025_2;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();       //任务
        int m = sc.nextInt();       //成员
        int[] taskDiff = new int[n];
        int[] taskPoint = new int[n];
        int[] ability = new int[m];
        for (int i = 0; i < n; i++) {
            taskDiff[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            taskPoint[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            ability[i] = sc.nextInt();
        }

        int ans = 0;
        for (int a : ability) {
            int maxPoint = 0;
            for (int i = 0; i < taskDiff.length; i++) {
                if(a>=taskDiff[i]){
                    maxPoint = Math.max(maxPoint,taskPoint[i]);
                }
            }
            ans+=maxPoint;
        }

        System.out.println(ans);

    }

}
