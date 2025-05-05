package algorithm;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//513.找数左下角的值
public class LeetCode513 {

    private int maxDepth;
    private int result;

    public int findBottomLeftValue(TreeNode root) {
        /**
         * 递归法
         */
        findBottomLeftValueSolution1(root, 1);
        return result;
    }

    /**
     * 递归法
     *
     * @param root
     * @param depth
     */
    private void findBottomLeftValueSolution1(TreeNode root, int depth) {
        /**
         * 思路：
         * 递归获取左右子树的最底层 最左边的叶子节点
         * 如果叶子节点的深度大于最大深度，就更新最大深度以及最终结果result
         */

        if (root.left == null && root.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                result = root.val;
            }
            return;
        }

        //递归获取左右子树的最底层 最左边的叶子节点
        if (root.left != null) {
            findBottomLeftValueSolution1(root.left, depth + 1);

        }
        if (root.right != null) {
            findBottomLeftValueSolution1(root.right, depth + 1);
        }

    }

}

class Solution513 {

    public int findBottomLeftValue(TreeNode root) {
        /**
         * 迭代法，层序遍历
         * 遍历每一层，然后记录每一层的第一个节点即可
         */

        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        //初始化栈
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                //记录每一层的第一个节点
                TreeNode pop = queue.poll();
                if(i==0) result=pop.val;
                if(pop.left!=null) queue.add(pop.left);
                if(pop.right!=null) queue.add(pop.right);
            }
        }
        return result;
    }

}
