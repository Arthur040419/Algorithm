package algorithm;

import java.util.Arrays;

//螺旋矩阵
public class LeetCode59 {
    public static void main(String[] args) {
        int[][] arr = generateMatrix(5);
        for (int i = 0; i < 5; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static int[][] generateMatrix(int n) {
        //仿示例代码
        int[][] arr = new int[n][n];
        //每次要放入的数据
        int value = 1;
        //代表行
        int row = 0;
        //代表列
        int column = 0;
        //代表圈的边长,每圈的边长等于n-（循环圈数-1）*2
        int side = n;
        //代表循环的圈数
        int loop = 1;
        while (loop <= n / 2) {
            //处理上行
            for (int i = 0; i < side - 1; i++) {
                arr[row][column++] = value++;
            }
            //处理右列
            for (int i = 0; i < side - 1; i++) {
                arr[row++][column] = value++;
            }
            //处理下行
            for (int i = 0; i < side - 1; i++) {
                arr[row][column--] = value++;
            }
            //处理左列
            for (int i = 0; i < side - 1; i++) {
                arr[row--][column] = value++;
            }
            //处理完一圈，圈数加1
            loop++;
            //边长减2
            side -= 2;
            //重设每圈的起点
            row = loop - 1;
            column = loop - 1;
        }
        //对n为奇数时单独处理
        if (n % 2 == 1) {
            arr[row][column]=n*n;
        }
        return arr;

    }

    public static int[][] generateMatrix_My(int n) {
        //掌握循环的原则，循环不变量原则
        //本题的循环不变量为 左闭右开
        if (n == 1) {
            int[][] arr = new int[1][1];
            arr[0][0] = 1;
            return arr;
        }
        int[][] arr = new int[n][n];
        //代表行
        int row = 0;
        //代表列
        int column = 0;
        //代表要放入值
        int value = 1;
        //代表待处理矩阵的边长
        int time = n;
        while (value <= n * n) {
            //处理上行
            for (int i = 0; i < time - 1; i++) {
                arr[row][column++] = value++;
                if (value > n * n) return arr;
            }
            //处理右列
            for (int i = 0; i < time - 1; i++) {
                arr[row++][column] = value++;
                if (value > n * n) return arr;
            }
            //处理下行
            for (int i = 0; i < time - 1; i++) {
                arr[row][column--] = value++;
                if (value > n * n) return arr;
            }
            //处理左列
            for (int i = 0; i < time - 1; i++) {
                arr[row--][column] = value++;
                if (value > n * n) return arr;
            }
            //一层一层处理，进入下一层
            row += 1;
            column += 1;
            //每处理完一回合处理的次数-1
            time -= 2;
            if (time == 1) {
                arr[row][column] = n * n;
                return arr;
            }
        }
        return arr;
    }
}
