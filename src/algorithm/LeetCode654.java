package algorithm;

import dataStructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

//654.最大二叉树
public class LeetCode654 {
    public static void main(String[] args) {
        constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        /**
         * 思路原题目都已经说出来了：
         * 创建一个根节点，其值为 nums 中的最大值。
         * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
         * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
         * 就根据这个步骤来
         *
         * 就是需要注意一些递归的细节：
         * 递归的终止条件是当数组长度为1的时候，就直接创建一个新节点返回即可，因为题目说明了数组长度大于等于1
         * 也因此我们在构建左右子树时也要判断左右数组的长度是否大于等于1
         * 还有就是分割数组采用索引来分割，而不是新创建一个数组，这样可以减少创建数组的耗时
         * 使用索引来分割数组就还要注意区间的范围是什么，这里我用的是左闭右开
         *
         */

        return constructMaximumBinaryTreeSolution(nums, 0, nums.length);

    }

    private static TreeNode constructMaximumBinaryTreeSolution(int[] nums, int begin, int end) {
        //如果数组长度为1
        if (end - begin == 1) return new TreeNode(nums[begin]);

        //找出当前数组范围的最大值
        int maxIndex = begin;
        for (int i = begin; i < end; i++) {
            if (nums[i] > nums[maxIndex]) maxIndex = i;
        }
        TreeNode root = new TreeNode(nums[maxIndex]);

        //递归获取左右子树
        if (maxIndex - begin >= 1) {
            root.left = constructMaximumBinaryTreeSolution(nums, begin, maxIndex);
        } else {
            root.left = null;
        }

        if (end - maxIndex - 1 >= 1) {
            root.right = constructMaximumBinaryTreeSolution(nums, maxIndex + 1, end);
        } else {
            root.right = null;
        }
        return root;
    }

}
