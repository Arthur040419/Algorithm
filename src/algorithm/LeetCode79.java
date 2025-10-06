package algorithm;

//79.单词搜索
public class LeetCode79 {

    private static int m;
    private static int n;

    public static void main(String[] args) {
        //生成一个3*2的二维数组测试用例
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist2(board, "ABCCED"));
    }

    public static boolean exist(char[][] board, String word) {
        /**
         * 思路：回溯法
         * 首先找到word的第一个字母，用一个len表示当前遍历的字母数量，从0开始，每成功遍历一个字母len就加1，如果len等于word的长度，说明单词搜索成功。
         * 第一个字母找到之后，遍历board，找到第一个字母的位置，然后上下左右四个方向进行回溯
         * 当所有的第一个字母都遍历完之后，如果len不等于word的长度，说明单词搜索失败。
         */
        m = board.length;
        n = board[0].length;

        int len = 0;
        boolean[][] visited = new boolean[m][n];        //表示i，j位置的元素已经访问过了
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (backtrack(board, visited, word, len, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;

    }

    public static boolean backtrack(char[][] board, boolean[][] visited, String word, int len, int i, int j) {
        if (i >= m || j >= n || i < 0 || j < 0) {
            return false;
        }
        if (visited[i][j]) {
            return false;
        }

        if (board[i][j] != word.charAt(len)) {
            return false;
        }

        visited[i][j] = true;
        len += 1;

        if (len == word.length()) {
            return true;
        }

        //上
        if (backtrack(board, visited, word, len, i - 1, j)) {
            return true;
        }
        //下
        if (backtrack(board, visited, word, len, i + 1, j)) {
            return true;
        }
        //左
        if (backtrack(board, visited, word, len, i, j - 1)) {
            return true;
        }
        //右
        if (backtrack(board, visited, word, len, i, j + 1)) {
            return true;
        }

        visited[i][j] = false;
        len -= 1;
        return false;
    }

    public static boolean exist2(char[][] board, String word) {
        /**
         * 思路2：官解思路
         * 定义一个check函数，调用该函数时传入起始坐标i,j，以及字符串的起始位置k
         * check表示检查从二维数组的i，j位置开始能否搜索到以位置k开始的字符串，如果可以就返回true
         * 对二维数组的每一个位置调用check函数，如果返回结果为true，说明能够搜索到字符串
         */
        m = board.length;
        n = board[0].length;

        int k = 0;
        boolean[][] visited = new boolean[m][n];        //表示i，j位置的元素已经访问过了
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (check(board, visited, word, i, j, k)) {
                    return true;
                }
            }
        }
        return false;

    }

    public static boolean check(char[][] board, boolean[][] visited, String word, int i, int j, int k) {
        if (i >= m || j >= n || i < 0 || j < 0 || visited[i][j]) {
            return false;
        }
        if (k == word.length() - 1 && word.charAt(k) == board[i][j] && !visited[i][j]) {
            return true;
        }
        if (board[i][j] != word.charAt(k)) {
            return false;
        }

        //定义四个方向
        int[][] directions = new int[][]{
                {-1, 0},    //上
                {1, 0},     //下
                {0, -1},    //左
                {0, 1}      //右
        };

        visited[i][j] = true;

        for (int[] direction : directions) {
            int newi = i + direction[0];
            int newj = j + direction[1];
            if (check(board, visited, word, newi, newj, k + 1)) {
                return true;
            }
        }

        visited[i][j] = false;
        return false;
    }


}
