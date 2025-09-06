package algorithm;

//74.搜索二维矩阵
public class LeetCode74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        /**
         * 思路：二分查找
         * 先查找目标值可能在哪一行，然后再在那一行中二分查找目标值
         * 对于二分查找，一定要记住，如果没有找到目标值，那么最终begin（left）指针指向的位置就是第一个大于目标值的位置
         */

        int m = matrix.length;
        int n = matrix[0].length;

        int begin = 0;
        int end = m - 1;

        //先查找行
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if(begin<=0){
            return false;
        }

        int line = begin-1;

        //查找列
        begin = 0;
        end = n - 1;

        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (matrix[line][mid] == target) {
                return true;
            } else if (matrix[line][mid] < target) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        return false;
    }
}
