package algorithm;

//62.不同路径
public class LeetCode62 {
    public int uniquePaths(int m, int n) {
        /**
         * 思路：
         * 1.确定dp数组,dp[i][j]表示到达坐标(i,j)的不同路径数
         * 2.确定状态转移方程，dp[i][j] = dp[i-1][j]+dp[i][j-1]
         * 3.初始化dp数组，这里第一行和第一列的路径数其实都可以确定了，都是1，这样初始化也不用担心遍历时的数组越界问题
         * 4.确定遍历顺序，从(1,1)坐标开始，从左往右，从上往下，这样就能保证在遍历的过程中前面的值不会出现空值
         */

        //创建dp数组
        int[][] dp = new int[m][n];

        //初始化dp数组
        //初始化第一列
        for (int i = 0; i < m; i++) {
            dp[i][0]=1;
        }
        //初始化第一行
        for (int i = 0; i < n; i++) {
            dp[0][i]=1;
        }

        //遍历dp数组
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}
