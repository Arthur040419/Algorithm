import java.util.HashMap;
import java.util.Map;

public class Test117 {

    public static void main(String[] args) {
        /**
         * 在二维字符数组中搜索某个字符串是否存在
         */

        char[][] chars = {
                {'a', 'b', 'c'},
                {'c', 'b', 'a'},
                {'e', 'f', 'g'}
        };
        String input = "abcef";

        Map<Integer, Integer> firstChar = new HashMap<>();
        char first = input.charAt(0);

        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                if (first == chars[i][j]) {
                    firstChar.put(i, j);
                }
            }
        }


        for (Map.Entry<Integer, Integer> integerIntegerEntry : firstChar.entrySet()) {
            if (ifFound(chars, input, integerIntegerEntry.getKey(), integerIntegerEntry.getValue())) {
                System.out.println("true");
                return;
            }
        }
        System.out.println("false");
    }

    public static boolean ifFound(char[][] chars, String input, int x, int y) {
        boolean[][] visited = new boolean[chars.length][chars[0].length];
        int[][] directions = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };

        for (int i = 1; i < input.length(); i++) {
            boolean flag = false;
            for (int j = 0; j < 4; j++) {
                int xx = x + directions[j][0];
                int yy = y + directions[j][1];
                if (0 <= xx && xx < chars[0].length && 0 <= yy && yy < chars.length && !visited[xx][yy] && chars[xx][yy] == input.charAt(i)) {
                    x = xx;
                    y = yy;
                    visited[xx][yy] = true;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return false;
            }

        }
        return true;
    }

}
