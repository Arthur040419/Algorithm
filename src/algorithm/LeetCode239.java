package algorithm;

import java.util.*;

//239.滑动窗口最大值
public class LeetCode239 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }


    public static int[] maxSlidingWindow(int[] nums, int k) {
        //看了别人的代码自己写的，思路同样是单调队列，但是别人只用了大概20行代码就搞定了，我下面的代码却用了80多行，好好学学别人的代码是咋写的吧。。。

        //虽然同样采用的是单调队列，但是别人单调队列中存放的是数组下标，这样的好处是可以很方便地判断队列第一个元素是否在滑动窗口范围内
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        //idx表示返回结果res的下标
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            //滑动窗口范围为[i-k+1,i]
            //如果队列第一个元素不在滑动窗口范围内，就将其弹出
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            //如果新增元素大于队尾元素就弹出队尾元素，直到新增元素小于队尾元素
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            //将新增元素存入单调队列（存下标）
            deque.offerLast(i);

            //每次滑动窗口，就将该窗口中的最大值存入返回结果中
            if (i >= k - 1) {
                res[idx++] = nums[deque.peekFirst()];
            }
        }

        return res;
    }

    //复习
    public static int[] maxSlidingWindow_Review(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Queue<Integer> queue = new LinkedList<>();
        //初始化单调队列
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && queue.peek() < nums[i]) {
                queue.poll();
            }
            queue.add(nums[i]);
        }

        //滑动窗口开始移动
        for (int i = 1; i < nums.length - k + 1; i++) {
            int remove = nums[i-1];     //移除的元素
            int add = nums[i+k-1];        //新元素

        }
        return null;
    }


    public int[] maxSlidingWindow_My(int[] nums, int k) {
        /**
         * 思路：
         * 使用单调队列来记录滑动窗口中可能的最大值
         * 维护一个单调递减的单调队列，用来存放滑动窗口中的元素
         * 比如如果滑动窗口元素为[3,2,4],那么单调队列中存放的就是[4]
         * 如果滑动窗口元素为[7,3,5],那么单调队列中存放的就是[7,5]
         * 将滑动窗口中的元素存入单调队列时是按如下规则来的：
         * 1.首先初始化单调队列，也就是滑动窗口还没开始移动的时候
         * 遍历滑动窗口中的元素，如果当前元素大于单调队列的第一个元素，直接清空队列并将当前元素存入队列
         * 如果当前元素小于单调队列的最后一个元素，直接将当前元素存入队列末尾
         * 如果当前元素小于队列第一个元素，但是大于队列最后一个元素，则将队列末尾元素弹出，直到队列末尾元素大于当前元素，就将当前元素存入队列末尾
         * 以上所有情况可以直接总结为：如果当前元素大于队尾元素，就弹出队尾元素，直到队尾元素大于或等于当前元素，即满足单调性时。
         *
         *  2.初始化完成后，滑动窗口开始移动，此时滑动窗口就是移除一个元素的添加一个新元素
         *  如果移除的元素等于队列的第一个元素，则将队列第一个元素弹出，否则不用管
         *  如果添加的元素大于队列的第一个元素，则清空队列，并将添加的元素存入队列
         *  如果添加的元素小于队列的第一个元素，但是大于队列的最后一个元素，则将队列末尾元素弹出，直到队列末尾元素大于当前元素，就将新元素存入队列末尾
         *  以上所有情况可以直接总结为：如果当前元素大于队尾元素，就弹出队尾元素，直到队尾元素大于或等于当前元素，即满足单调性时。
         *  （所以就不要像我下面的代码那样分那么多种情况了，实际上一行代码就可以搞定，详见上面别人的代码）
         *
         *  要获取当前窗口的最大元素时，直接取出当前队列的第一个元素即可
         */

        //单调递减队列
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        //left和right表示滑动窗口的范围
        int left = 0;
        int right = k - 1;
        //初始化队列
        for (int i = left; i <= right; i++) {
            addElement(nums[i], deque);
        }
        result[left] = deque.peekFirst();
        //开始移动滑动窗口
        left++;
        right++;
        while (right < nums.length) {
            //处理移除的元素
            if (nums[left - 1] == deque.peekFirst()) {
                //如果移除的元素为队列的第一个元素，直接弹出队列第一个元素
                deque.pollFirst();
            }
            //处理添加的元素
            addElement(nums[right], deque);
            result[left] = deque.peekFirst();
            left++;
            right++;

        }
        return result;
    }

    private static void addElement(int num, Deque<Integer> deque) {
        if (deque.isEmpty() || num > deque.peekFirst()) {
            deque.clear();
            deque.offerLast(num);
        } else if (num <= deque.peekFirst()) {
            while (deque.peekLast() < num) {
                //如果队列最后一个元素小于当前元素，则弹出最后一个元素
                deque.pollLast();
            }
            deque.offerLast(num);
        }
    }


}
