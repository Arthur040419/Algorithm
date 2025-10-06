package shunfeng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {

    static long result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        result = 0;
        backtrack(n, m, k, new ArrayList<>());
        System.out.println(result % ((long) Math.pow(10, 9) + 7));
    }

    public static void backtrack(int n, int m, int k, List<Integer> list) {
        if (list.size() == n) {
            result++;
            //System.out.println(list.toString());
            return;
        }

        if (list.isEmpty()) {
            for (int i = 1; i <= m; i++) {
                list.add(i);
                backtrack(n, m, k, list);
                list.remove(list.size() - 1);
            }
            return;
        }

        int lastNum = list.get(list.size() - 1);
        //相差不超过k
        int nextNum =  Math.max(lastNum - k,1);
        while (nextNum <= m) {
            if (Math.abs(nextNum - lastNum) <= k && nextNum % lastNum != 0) {
                list.add(nextNum);
                backtrack(n, m, k, list);
                list.remove(list.size() - 1);
            }
            nextNum++;
        }

        //整数倍
        nextNum = lastNum;
        while (nextNum <= m) {
            list.add(nextNum);
            backtrack(n, m, k, list);
            list.remove(list.size() - 1);
            nextNum += lastNum;
        }
    }

}
