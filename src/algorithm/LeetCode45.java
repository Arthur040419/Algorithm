package algorithm;

//45.跳跃游戏II
public class LeetCode45 {
    public int jump(int[] nums) {
        /**
         * 思路：
         * 要使得到达最后一个元素的跳跃次数最少，那就只在必须要跳的时候才跳
         * 而什么时候是必须要跳的时候呢？就是在当前元素的覆盖范围够不到最后一个元素的时候就必须要跳
         * 至于要跳到具体哪一个元素，这个不重要，重要的是跳跃后新的覆盖范围是否能够覆盖到最后一个元素
         * 如果可以，说明就不用继续跳了，如果不行，说明还需要接着跳跃
         * 所以我们需要不断更新下一次跳跃后的最大覆盖范围
         */

        //当前元素的覆盖范围
        int curCover = 0;
        //下一次跳跃的覆盖范围
        int nextCover = 0;
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            if(i>curCover){
                //如果当前覆盖范围无法到达目前遍历到的索引，自然也无法到达最后一个元素，所以此时需要跳跃
                curCover = nextCover;
                result++;
            }
            //获取下一次跳跃的最大覆盖范围
            nextCover = Math.max(nextCover,nums[i]+i);

            //如果当前覆盖范围已经大于等于最后一个元素的索引时，说明不需要再进行跳跃了
            if(curCover>=nums.length-1) break;
        }
        return result;

    }
}
