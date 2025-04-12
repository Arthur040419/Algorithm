package algorithm;

import java.util.Scanner;

//开发商购买土地
public class KamaCoder44 {
    public static void main(String[] args) {
        buyLand();
    }

    public static void buyLand() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] lands = new int[n][m];
        //min表示两块区域土地的最小权值差
        int min = Integer.MAX_VALUE;
        //输入土地的权值，并顺便统计横向土地权值和以及纵向土地权值和
        //row[i]表示第i行的所有土地的权值和
        int[] row = new int[n];
        //column[j]表示第j列的所有土地权值和
        int[] column = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                lands[i][j] = sc.nextInt();
                row[i] += lands[i][j];
                column[j] += lands[i][j];
            }
        }

        //计算横向前缀和，preRow[i]表示前i行的所有土地权值和
        int[] preRow = new int[n];
        preRow[0] = row[0];
        for (int i = 1; i < row.length; i++) {
            preRow[i] = preRow[i - 1] + row[i];
        }

        //计算纵向前缀和，preColumn[j]表示前j列的所有土地的权值和
        int[] preColumn = new int[m];
        preColumn[0] = column[0];
        for (int i = 1; i < column.length; i++) {
            preColumn[i] = preColumn[i - 1] + column[i];
        }

        //横向划分
        for (int i = 1; i < preRow.length; i++) {
            int dif = Math.abs(preRow[preRow.length - 1] - preRow[i - 1]*2);
            min = dif < min ? dif : min;
        }

        //纵向划分
        for (int i = 1; i < preColumn.length; i++) {
            int dif = Math.abs(preColumn[preColumn.length - 1] - preColumn[i - 1]*2);
            min = dif < min ? dif : min;
        }
        System.out.println(min);

    }
}
