package algorithm;

//283.移动零
public class LeetCode283 {

    //优化后，耗时2ms
    public void moveZeroes_Optimize(int[] nums) {
        /**
         * 慢指针实际上指向的就是已经处理好的序列的末尾位置
         * 快指针就用来遍历数组，如果发现元素不等于0，就与慢指针指向的位置交换
         */

        int slow = 0;
        int fast = 0;
        while (fast<nums.length){
            //这里也不能大于0，因为元素可能是小于0的
            //if(nums[fast]>0){
            if(nums[fast]!=0){
                swap(slow,fast,nums);
                slow++;
            }
            fast++;
        }
    }

    public void swap(int slow,int fast,int[] target){
        int tmp = target[slow];
        target[slow] = target[fast];
        //这里不能直接等于0，因为slow和fast可能指向的是同一个位置
        //target[fast] = 0;
        target[fast] = tmp;
    }


    //耗时33ms
    public void moveZeroes(int[] nums) {
        /**
         * 思路：快慢指针
         * 其中慢指针指向0的位置，也就是要交换的位置
         * 快指针从慢指针后面开始寻找，找到第一个不为0的数，指向指向非0的位置，
         * 然后交换两个指针的数值
         * 如果快指针已经超出了数组的长度，但是还没有找到非0元素，说明所有非0元素已经全部到最左边了，结束
         */

        int slow = 0;
        int fast = 0;

        int tmp = 0;
        while (fast != nums.length && slow != nums.length) {
            //寻找第一个0
            while (slow < nums.length && nums[slow] != 0) {
                slow++;
            }
            //寻找slow后面的第一个非0元素
            fast = slow;
            while (fast < nums.length && nums[fast] == 0) {
                fast++;
            }

            if (fast < nums.length) {
                //交换两数
                nums[slow] = nums[fast];
                nums[fast] = 0;
            }
        }
    }
}
