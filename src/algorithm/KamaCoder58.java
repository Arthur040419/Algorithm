package algorithm;

import java.util.Scanner;

//区间和
public class KamaCoder58 {
    public static void main(String[] args) {
        subArrSum();

    }

    //复习
    public static void subArrSum_Review(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        //前缀和
        int[] preSum = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
            if(i!=0){
                preSum[i] = preSum[i-1]+arr[i];
            }else {
                preSum[i] = arr[i];
            }
        }
        while(sc.hasNextInt()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(preSum[b] - preSum[a] + arr[a]);
        }

    }

    public static void subArrSum() {
        //前缀和
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //前缀和数组，p[i]表示arr[0]~arr[i]的和
        int[] p = new int[n];
        //初始化数组
        p[0] = sc.nextInt();
        for (int i = 1; i < n; i++) {
            int num = sc.nextInt();
            p[i] = p[i - 1] + num;
        }
        int a;
        int b;
        //这里循环条件注意别用true，用sc.hasNext这些
        while(sc.hasNextInt()){
            //输入区间
            a=sc.nextInt();
            b=sc.nextInt();
            if(a==0){
                //对左边界为0的时候特殊处理
                System.out.println(p[b]);
            }else {
                System.out.println(p[b] - p[a - 1]);
            }
        }
        sc.close();

    }
}
