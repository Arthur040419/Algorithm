package algorithm;

//474.一和零
public class LeetCode474 {

    public int findMaxForm(String[] strs, int m, int n) {
        /**
         * 思路：
         * 看起来像背包问题，就把m、n抽象成背包的容量，背包最多只能放m个0和n个1
         * 把strs抽象成物品
         * //1.定义dp数组
         * dp[i][j]表示背包放i个0和j个1时，最大的子集长度
         *
         * //2.写出状态转移方程
         * 遍历strs数组的每一个元素，每遍历一个元素的同时都要遍历dp数组，更新dp的最大值
         * 假设当前遍历的strs的元素有x个0和y个1，那么状态转移方程就为：
         * dp[i][j] = Max(dp[i][j],dp[i-x][j-y]+1);
         *
         * //3.初始化dp数组
         * dp[0][0] = 0
         *
         * //4.确定遍历顺序
         * 特别注意，在二维背包问题中，需要先遍历物品，确保放入背包中的物品有多个，而不是只有一个
         * 后遍历容量，且一定要注意遍历容量时要从后往前遍历，这样可以保证物品不会被重复放
         */

        //定义dp数组
        int[][] dp = new int[m + 1][n + 1];

        //初始化dp数组
        dp[0][0] = 0;

        //遍历strs数组（先遍历物品）
        for (String str : strs) {
            //计算str中有多少个0，多少个1
            int zeroCnt = 0;
            int oneCnt = 0;
            char[] charArray = str.toCharArray();
            for (int i = 0; i < str.length(); i++) {
                if (charArray[i] == '0') {
                    zeroCnt++;
                } else {
                    oneCnt++;
                }
            }

            //遍历dp数组（后遍历容量） 注意：遍历容量一定要从后往前遍历，这样可以防止物品被重复放入
            for (int i = m; i >= 0; i--) {
                for (int j = n; j >= 0; j--) {
                    if (i - zeroCnt >= 0 && j - oneCnt >= 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - zeroCnt][j - oneCnt] + 1);
                    }
                }
            }
        }

        return dp[m][n];
    }

}
