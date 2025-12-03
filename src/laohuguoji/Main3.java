package laohuguoji;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//最长的平衡子序列
public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int res = 0;
        map.put(input.charAt(0), 1);
        while (left <= right) {
            if (map.getOrDefault('L', 0).equals(map.getOrDefault('H', 0))) {
                res = Math.max(res, right - left + 1);
            } else if (right - left + 1 > res) {
                int tmpLeft = left;
                Map<Character, Integer> tmpMap = new HashMap<>(map);
                while (tmpLeft <= right) {
                    if (map.getOrDefault('L', 0).equals(map.getOrDefault('H', 0))) {
                        res = Math.max(res, right - tmpLeft + 1);
                    }
                    if (tmpMap.getOrDefault(input.charAt(tmpLeft), 0) != 0) {
                        tmpMap.put(input.charAt(tmpLeft), tmpMap.getOrDefault(input.charAt(tmpLeft), 0) - 1);
                    }
                    tmpLeft++;
                }
            }
            if (right != input.length() - 1) {
                right++;
                map.put(input.charAt(right), map.getOrDefault(input.charAt(right), 0) + 1);
            } else {
                left++;
                if (left < input.length()) {
                    map.put(input.charAt(left), map.getOrDefault(input.charAt(left), 0) + 1);
                }
            }
        }

        System.out.println(res);
    }


}
