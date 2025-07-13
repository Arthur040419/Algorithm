package yongyou_2025;

import java.util.Scanner;

//用友2025笔试第二题
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        //设备数量
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i]=sc.nextInt();
        }
        //升级成本
        int[] price = new int[N];
        for (int i = 0; i < N; i++) {
            price[i]=sc.nextInt();
        }
        //出售金额
        int[] sell = new int[N];
        for (int i = 0; i < N; i++) {
            sell[i]=sc.nextInt();
        }
        //升级总预算
        int[] money = new int[N];
        for (int i = 0; i < N; i++) {
            money[i]=sc.nextInt();
        }

        //处理每一种设备
        for (int i = 0; i < N; i++) {
            calMaxUpgradeNum(nums[i],price[i],sell[i],money[i]);
        }

    }

    public static void calMaxUpgradeNum(int num,int price,int sell,int money){
        //升级总预算，包括卖设备得到的预算
        int allMoney = money;
        for (int i = num; i >= 0; i--) {
            allMoney = money;
            allMoney+=sell*(num-i);
            if(allMoney>=i*price){
                System.out.print(i);
                System.out.print(" ");
                return;
            }

        }

    }

}
