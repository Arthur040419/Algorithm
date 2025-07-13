package algorithm;

//134.加油站
public class LeetCode134 {
    public static void main(String[] args) {
        canCompleteCircuit(new int[]{1,2,3,4,5},new int[]{3,4,5,1,2});
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        /**
         * 思路：
         * 计算每一个节点能够剩下的油
         * 从0开始累加剩下的油，也就是计算[0,i]这个区间的剩余油总和
         * 如果这个剩余油的总和出现小于0的情况，说明从0节点开始，中间出现了断油情况
         * 说明，就不能从节点0开始，因此需要更新起点为i+1，再从起点i+1重新开始计算剩余油总和，重复上面的步骤
         * 如果累加到了最后一个节点，并且当前起点i到最后一个节点的总和能够满足起点前面所有节点的用油需求，就说明当前起点是最终结果
         */

        //当前区间的剩余油量总和
        int curSum = 0;
        //从0到当前节点的剩余油总和，如果该值大于0，说明当前区间的剩余油总和能够满足前面节点的用油需求
        int total = 0;
        //起点
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            int rest = gas[i] - cost[i];
            //踩坑点，这里写反了
//            int rest = cost[i] - gas[i];
            curSum += rest;
            total += rest;
            //如果出现小于0的情况，说明出现了断油
            if (curSum < 0) {
                start = i + 1;
                curSum = 0;
            }

        }

        //如果total小于0，说明当前区间剩余油无法满足前面节点的用油需求
        if (total < 0) return -1;
        return start;

    }
}
