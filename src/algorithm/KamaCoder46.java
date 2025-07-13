package algorithm;

import java.util.Scanner;

//46.携带研究材料
public class KamaCoder46 {
    public static void main(String[] args) {
        bag_solution1();

    }

    //动态规划方法一：二维数组
    public static void bag_solution1(){
        /**
         * 思路： 01背包问题
         * 1.确定dp数组，dp[i][j]表示容量为j的背包只放如前i个物品时的最大价值,假设weight[i]表示第i个物品的重量，value[i]表示第i个物品的价值
         * 2.确定递推公式，每一个物品可以选择放入或不放入，因此会有如下两种情况
         * 放入第i个物品：那么此时背包中物品的总价值应该为：dp[i-1][j-[i]]+value[i]
         * 不放入第i个物品，那么此时背包中物品的总价值应该为：dp[i-1][j]
         * 而dp[i][j]就是取这两种情况的最大值
         * 因此可以推出递推公式为：dp[i][j] = Max(dp[i-1][j-[i]]+value[i],dp[i-1][j])
         * 3.初始化dp数组
         * 首先可以明确知道，当背包容量为0时，dp[i][0]都为0
         * 其次，看上面推导出来的递推公式，可以发现递推公式依赖于i-1,因此需要先初始化i为0的情况
         * i为0时，如果容量大于weight[0],那么dp[0][j] = value[0]
         * 如果容量小于weight[0]，那么dp[0][j] = 0
         *
         * 4.确定遍历顺序
         * 不管是先遍历物品后遍历容量还是先遍历容量后遍历物品都可以
         * 因为dp[i][j]的值依赖于dp[i][j]的上面的值（dp[i-1][j]）或者左上角的值(dp[i-1][j-weight[i]]+value[i])
         */

        Scanner sc  = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        //物品重量
        int[] weight = new int[M];
        //物品价值
        int[] value = new int[M];

        for (int i = 0; i < M; i++) {
            weight[i] = sc.nextInt();
        }

        for (int i = 0; i < M; i++) {
            value[i] = sc.nextInt();
        }

        //定义dp数组
        int[][] dp = new int[M][N+1];

        //初始化dp数组
        for (int i = 0; i < M; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i < N+1; i++) {
            if(i>=weight[0]) dp[0][i] = value[0];
            else dp[0][i]=0;
        }

        //遍历dp数组，这里采用先遍历物品，后遍历容量
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N + 1; j++) {
                //如果容量放不下你
                if(j<weight[i]) dp[i][j] = dp[i-1][j];
                    //如果放得下
                else dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i]);
            }

        }

        System.out.println(dp[M - 1][N]);
    }

    //动态规划方法二：滚动数组
    public static void bag_solution2(){
        /**
         * 思路：
         * 背包问题的另一种写法：滚动数组
         * 1.定义dp数组 dp[j]表示容量为j时背包能够存放物品的最大价值
         * 2.推导递推公式，dp[j] = max(dp[j],dp[j-weight[i]]+value[i]),i表示物品的索引
         * 所以实际上滚动数组也是在遍历每一个物品，在遍历每一个物品时，如果发现更大的值就可以随时更新dp[j],否则dp[j]就不会变。
         * 其实这种方法我最开始疑惑的点在于dp[j-weight[i]]+value[i]是如何保证不会放入重复的物品的
         * 实际上为了保证不会放入重复的物品，可以采用倒序遍历的方式，即遍历dp[j]时从背包容量最大值往前遍历
         * 3.初始化dp数组，dp[0] = 0
         * 4.确定遍历顺序
         * 滚动数组的遍历方式一定要弄明白
         * 遍历时先遍历物品，再遍历容量，并且容量是倒序遍历
         * 先遍历物品是为了保证背包中可以放入多个物品，如果先遍历容量，再遍历物品，那么背包中最终放入的物品只有一个（因为容量是倒序遍历的，在遍历后面的容量时，前面的容量还没放东西）
         * 容量倒序遍历就是保证物品不会被重复放入
         */

        //处理数据
        Scanner sc  = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        //物品重量
        int[] weight = new int[M];
        //物品价值
        int[] value = new int[M];

        for (int i = 0; i < M; i++) {
            weight[i] = sc.nextInt();
        }

        for (int i = 0; i < M; i++) {
            value[i] = sc.nextInt();
        }

        //定义dp数组
        int[] dp = new int[N+1];

        //初始化dp数组
        dp[0] = 0;

        //遍历dp数组，先遍历物品，再倒序遍历容量
        for (int i = 0; i < M; i++) {
            for (int j = N; j > 0; j--) {
                //这里不能忘了做健壮性判断
                if(j-weight[i]>=0) dp[j] = Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
        }


        System.out.println(dp[N]);
    }
}
