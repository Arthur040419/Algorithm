package algorithm;

import dataStructure.TreeNode;

//108.将有序数组转换为二叉搜索树
public class LeetCode108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        /**
         * 思路：
         * 通过数组构造一颗二叉树的关键点在于找到数组的分割点，以分割点作为根节点，然后对左半部分和右半部分递归构造二叉树
         * 而对于平衡二叉搜索树会更加简单，因为平衡二叉搜索树的根节点一定在中间
         * 只不过如果数组长度为偶数，数组的中间值有两个，可能需要想一想到底去中间的哪一个，但实际上选哪个都一样，只不过构造出来的二叉树略有不同，但都是符合题意的
         */

        return findRoot(nums, 0, nums.length);

    }

    private TreeNode findRoot(int[] nums, int begin, int end) {
        //注意，需要明确区间范围，这里选择包前不包后
        //踩坑点1：忘记了终止条件，当范围内只有一个节点时，直接返回该节点
        if (end - begin == 1) return new TreeNode(nums[begin]);
        int mid = (begin + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        //踩坑点2：没有考虑到数组范围长度为0的情况。
        if (begin < mid) root.left = findRoot(nums, begin, mid);
        if (mid + 1 < end) root.right = findRoot(nums, mid + 1, end);
        return root;
    }

    //复习
    private TreeNode findRoot_Review(int[] nums, int begin, int end) {
        if (end - begin == 1) return new TreeNode(nums[begin]);
        int mid = (begin + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        if (begin < mid) root.left = findRoot_Review(nums, begin, mid);
        if (mid + 1 < end) root.right = findRoot_Review(nums, mid + 1, end);
        return root;
    }

}
