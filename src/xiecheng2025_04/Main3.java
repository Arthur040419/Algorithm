package xiecheng2025_04;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //dp[i][j]表示索引从i到j的子数组是否为好数组
        boolean[][] dp = new boolean[n][n];
        boolean[][] isSplit = new boolean[n][n];

        int count = 0;
        if (n > 0) count = n;
        //初始化dp数组
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        //获取所有连续子数组，从长度为2的数组开始，因为长度为1的数组一定是好数组
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < n - i + 1; j++) {
                if (i == 2) {
                    count++;
                    dp[j][j + 1] = true;
                    if (arr[j] > arr[j + 1]) isSplit[j][j + 1] = true;
                } else {
                    //子数组范围为包前不包后
                    if (isGoodArr(j, j + i, arr, dp, isSplit)) count++;
                }
            }
        }

        System.out.println(count);
    }

    //优化后的
    private static boolean isGoodArr(int begin, int end, int[] arr, boolean[][] dp, boolean[][] isSplit) {
        boolean flag = true;
        if (!(dp[begin + 1][end - 1] && arr[begin] <= arr[begin + 1])) {
            if (!isSplit[begin + 1][end - 1] && arr[begin] < arr[end - 1]){
                flag = false;
            }
            if(!isSplit[begin + 1][end - 1] && arr[begin] >= arr[end - 1]){
                isSplit[begin][end-1] = true;
            }
            if (isSplit[begin + 1][end - 1]) {
                flag = false;
            }
        }
        if (!(dp[begin][end - 2] && arr[end - 2] <= arr[end - 1])) {
            if (!isSplit[begin][end - 2] && arr[end - 1] > arr[begin]){
                flag = false;
            }
            if(!isSplit[begin][end - 2] && arr[end - 1] <= arr[begin]){
                isSplit[begin][end-1] = true;
            }
            if (isSplit[begin][end - 2]) {
                flag = false;
            }
        }
        if (flag){
            dp[begin][end - 1] = true;
            if(isSplit[begin + 1][end - 1]||isSplit[begin][end - 2]){
                isSplit[begin][end-1] = true;
            }
        }
        return flag;
    }


    //判断子数组是否为好数组
    private static boolean isGoodArr_bck(int begin, int end, int[] arr) {
        int mid = begin;
        //找到左边最长的单调递增长度
        while (mid < end - 1) {
            if (arr[mid] <= arr[mid + 1]) {
                mid++;
            } else {
                break;
            }
        }
        //如果递增长度为整个数组的长度，直接返回true
        if (mid == end - 1) return true;

        //接着判断后半部分是否为递增
        mid++;
        while (mid < end - 1) {
            if (arr[mid] <= arr[mid + 1]) {
                mid++;
            } else {
                return false;
            }
        }
        //如果后半段的最大值大于前半段的最小值，直接返回false
        if (arr[mid] > arr[begin]) return false;
        return true;
    }
}
