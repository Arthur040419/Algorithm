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

        //标记矩阵
        boolean[][] mark = new boolean[matrix.length][matrix[0].length];
        //定义矩阵边界
        int row = matrix.length;
        int col = matrix[0].length;

        //四个方向
        int[][] directions = new int[4][2];
        //右
        directions[0][0] = 0;
        directions[0][1] = 1;
        //下
        directions[1][0] = 1;
        directions[1][1] = 0;
        //左
        directions[2][0] = 0;
        directions[2][1] = -1;
        //上
        directions[3][0] = -1;
        directions[3][1] = 0;

        //开始模拟
        int x = 0;
        int y = 0;
        int direction = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < row * col; i++) {
            result.add(matrix[y][x]);
            mark[y][x] = true;
            x += directions[direction][0];
            y += directions[direction][1];
            if (mark[y][x] || 0 > x || x >= col || 0 > y || y >= row) {
                direction = (direction + 1) % 4;
            }
        }

        return null;
    }
}
