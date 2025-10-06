package pdd20250928;

import java.util.Scanner;

public class Main2 {
    static int res = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] init = new int[n];
        int[] target = new int[n];
        for (int i = 0; i < n; i++) {
            init[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            target[i] = sc.nextInt();
        }
        fun(init, target, 0, 0);
        System.out.println(res);
    }

    public static void fun(int[] init, int[] target, int root, int lastRootChange) {
        int curRootChange = 0;
        if(init[root]==0){
            return;
        }
        curRootChange = (target[root] + 5 - init[root]) % 5 - lastRootChange % 5;
        if(curRootChange<0){
            curRootChange+=5;
        }
        res += curRootChange;
        int left = 2 * root + 1;
        int right = 2 * root + 2;
        if (left < init.length) {
            fun(init, target, left, lastRootChange + curRootChange);
        }
        if (right < init.length) {
            fun(init, target, right, lastRootChange + curRootChange);
        }
    }

}
