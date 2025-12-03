package algorithm;

import dataStructure.TreeNode;

//337.打家劫舍III
public class LeetCode337 {

    public int rob(TreeNode root) {
        /**
         * 这题是树型dp，没看解析前确实不会
         * 解析详见笔记或代码随想录
         */

        int[] money = getMoney(root);
        return Math.max(money[0], money[1]);
    }

    //获取从某个节点开始，偷或不偷的最大金额，返回一个长度为2的数组，分别表示偷或不偷
    public int[] getMoney(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] arr = new int[2];

        int[] left = getMoney(node.left);
        int[] right = getMoney(node.right);

        //当前节点要偷
        arr[0] = left[1] + right[1] + node.val;

        //当前节点不偷
        arr[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return arr;
    }
}
