package algorithm;

//376.摆动序列
public class LeetCode376 {
    public int wiggleMaxLength(int[] nums) {
        /**
         * 思路：
         * 可以根据数组的值，画出一个折线图，不难发现，折线图的峰顶或者坡底都能算一个摆动序列的一个点
         * 也就是当前节点nums[i]减去前一个节点nums[i-1]的差previousDiff
         * 与后一个节点nums[i+1]减去当前节点nums[i]的差beforeDiff正负是不同的时候，说明就是峰顶或坡底
         * 但是这里需要考虑三种特殊情况：
         * 1.对于连续的水平坡面应该算几个节点呢？
         * 对于水平坡面，比如 1 2 2 2 1
         * 只需要在水平坡面的多个节点中取出一个即可，为了方便，统一取最后一个，也就是当nums[i]-nums[i-1]=0&&nums[i+1]-nums[i]<0的时候
         * 对于 2 1 1 1 2这个序列也是同理，也就是当nums[i]-nums[i-1]=0&&nums[i+1]-nums[i]>0的时候
         *
         * 2.对于单调坡与水平坡同时出现的情况
         * 比如 1 2 2 2 3 4 这个序列
         * 中间的2 2 2就是水平坡，但是整个序列的坡是单调的，这个时候就不能像第一种特殊情况那样取水平坡的最后一个2了
         * 要解决这种情况，我们可以通过仅在出现峰顶或坡底的时候才去更新previousDiff来避免错误地记录这个序列中水平坡的最后一个2的情况
         *
         * 3.对于首尾节点，我们无法通过previousDiff和beforeDiff来判断节点是否满足条件，因为首尾节点最多只会关联2个节点
         * 要解决这个问题，我们可以假设首节点前面已经存在一个与首节点相同的节点，这样对于首节点就可以通过previousDiff和beforeDiff来判断
         * 对于末尾节点，我们就默认存在一个峰顶或坡底（实际上确实至少存在一个），也就是末尾节点
         *
         *
         * 其实就可以把previousDiff和beforeDiff看成是单调的趋势，如果大于0，说明单调递增，小于0，说明单调递减
         */

        int result = 1;
        //假设首节点前面存在一个与首节点相同的节点，这样的话刚开始previousDiff就为0
        int previousDiff = 0;
        int beforeDiff = 0;

        for (int i = 0; i < nums.length-1; i++) { //最后一个节点不需要判断
            beforeDiff = nums[i+1]-nums[i];
            if((previousDiff<=0&&beforeDiff>0)||(previousDiff>=0&&beforeDiff<0)){
                result++;
                //仅在出现峰顶或坡底时才更新previousDiff
                previousDiff = beforeDiff;
            }

        }

        return result;
    }
}
