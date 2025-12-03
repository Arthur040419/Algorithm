package boleGame;

import java.util.Deque;
import java.util.LinkedList;

//力量封印
public class Main2 {

    public boolean is_perfect_seal(int[] nums) {
        //使用栈模拟力量开启封印顺序，如果为正数就是开启力量，将数字入栈，如果为负数就是封印力量，判断栈顶元素绝对值是否与当前值一致，不一致则说明顺序不对

        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                stack.push(nums[i]);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Integer top = stack.pop();
                if (top != Math.abs(nums[i])) {
                    return false;
                }
            }

        }

        return true;

    }

}
