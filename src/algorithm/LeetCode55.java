package algorithm;

//55.跳跃游戏
public class LeetCode55 {
    public boolean canJump(int[] nums) {
        /**
         * 思路：
         * 对于每一个元素，它能够到达的范围就是它本身的索引加上其对应的值，
         * 比如第1个元素，该元素值为3，那么这个元素能够到达的最大范围就是（索引）0+3 = 3（索引）
         * 而在（索引）1到（索引）3这个范围内的每一个元素又可以扩充覆盖的范围，例如：假如（索引）1的值也为3，那么该元素能够覆盖的范围就是1+3=4，此时说明能够到达的最大范围就变为了4
         * 依次类推，每遍历一个元素都可以尝试扩充覆盖范围
         * 如果扩充后的范围大于等于最后一个元素的下标，说明能够到达最后一个元素
         */

        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover, nums[i] + i);
            if (cover >= nums.length - 1) return true;
        }

        return false;

    }
}
