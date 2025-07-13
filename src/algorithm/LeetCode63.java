package algorithm;

//63.不同路径II
public class LeetCode63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /**
         * 思路：
         * 这题和LeetCode62思路上类似，不过有些地方需要特殊处理
         * 对于存在障碍的坐标，就让其dp[i][j]=0即可
         * 然后在初始化时，初始化第一行和第一列时，只要遇到障碍，后面的dp[i][j]就都是0，因为有障碍，后面的坐标就肯定无法到达
         */

        //定义dp数组
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        //初始化dp数组
        //初始化行
        for (int i = 0; i < obstacleGrid[0].length && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }
        //初始化列
        for (int i = 0; i < obstacleGrid.length && obstacleGrid[i][0] == 0; i++) {
            dp[i][0]=1;
        }

        //遍历dp数组
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                //如果坐标上不存在障碍物才更新其值
                if(obstacleGrid[i][j]==0){
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }

            }
        }

        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
