package algorithm;

import java.util.ArrayList;
import java.util.List;

//54.螺旋矩阵
public class LeetCode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        /**
         * 思路：直接模拟
         * 需要用到一个标记矩阵用来记录矩阵的某个元素是否已经被输出过了
         * 还需要定义遍历时的四个方向：右：(0,1) 下：(1,0) 左：(0,-1) 上：(-1,0)
         *
         */

        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();

        boolean[][] visited = new boolean[m][n];
        //定义方向
        int[][] directions = {
                {0, 1},  //右
                {1, 0},  //下
                {0, -1}, //左
                {-1, 0}  //上
        };

        int i = 1;
        int direction = 0;      //当前方向，开始为右
        int x = 0;
        int y = 0;
        while (i <= m * n) {
            visited[x][y] = true;
            res.add(matrix[x][y]);
            i++;
            int xx = x + directions[direction][0];
            int yy = y + directions[direction][1];
            if (xx < 0 || yy < 0 || xx >= m || yy >= n || visited[xx][yy]) {
                direction = (direction + 1) % 4;
                xx = x + directions[direction][0];
                yy = y + directions[direction][1];
            }
            x = xx;
            y = yy;
        }
        return res;
    }
}
