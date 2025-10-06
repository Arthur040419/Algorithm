package algorithm;

//73.矩阵置零
public class LeetCode73 {
    public void setZeroes(int[][] matrix) {
        /**
         * 思路：
         * 这题首先不能一边遍历，判断是否为0，一边对原矩阵进行修改，因为这样会导致原矩阵发生变化。
         * 可以采用标记数组，如果matrix[i][j]为0，那么就将该位置对应的行和列标记为true，被标记为true的行列的值最终都应该变为0
         */

        //开始标记
        //行标记
        boolean[] row = new boolean[matrix.length];
        //列标记
        boolean[] col = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        //开始置零
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }

    }
}
