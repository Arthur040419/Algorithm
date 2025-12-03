package laohuguoji;

//二维矩阵搜索
public class Main1 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (target < matrix[0][0]) {
            return false;
        }
        if (target > matrix[matrix.length - 1][matrix[0].length - 1]) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        //寻找所在行
        int i = 0;
        for (; i < m - 1; i++) {
            if (target == matrix[i][0] || target == matrix[i + 1][0]) {
                return true;
            }
            if (target > matrix[i][0] && target < matrix[i + 1][0]) {
                break;
            }
        }

        return binSearch(matrix[i], target);

    }

    public boolean binSearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (target == arr[mid]) {
                return true;
            }
            if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            }
        }
        return false;
    }

}
