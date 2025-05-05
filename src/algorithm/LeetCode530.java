package algorithm;

import dataStructure.TreeNode;

import java.util.Stack;

//530.二叉搜索树的最小绝对差
public class LeetCode530 {

    private TreeNode pre;
    int min;

    public int getMinimumDifference(TreeNode root) {
        /**
         * 思路：
         * 我们知道，二叉搜索树通过中序遍历的结果是一个递增的有序数组
         * 因此，这题最简单的思路就是直接中序遍历整个二叉树，得到一个有序的数组，然后再遍历有序数组找到最小的绝对差
         * 但是这里可以再简化一下，通过记录前一个节点，直接再遍历的过程中进行比较，就不需要得到数组后再遍历一遍了
         */

        pre = null;
        min = Integer.MAX_VALUE;
        //题目说树最少有两个节点，因此可以不处理root为null的情况
        getMinimumDifferenceSolution(root);
        return min;
    }

    private void getMinimumDifferenceSolution(TreeNode cur) {
        if (cur.left != null) getMinimumDifferenceSolution(cur.left);
        if (pre != null) {
            int tmp = Math.abs(cur.val - pre.val);
            if (tmp < min) {
                min = tmp;
            }
        }
        pre = cur;
        if (cur.right != null) getMinimumDifferenceSolution(cur.right);


    }

    //迭代法
    public int getMinimumDifference_2(TreeNode root) {
        /**
         * 采用统一迭代法来进行中序遍历，即将节点存入栈中，如果是需要处理的节点，就在其后面加上null
         * 当弹出null时，就再弹出一个节点，将该节点与pre节点相减，得到差值，再与min对比
         */

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        //这里忘记初始化了，出现了一次错误
        pre = null;
        min = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            if (top != null) {
                if (top.right != null) stack.push(top.right);
                stack.push(top);
                stack.push(null);
                if (top.left != null) stack.push(top.left);
            } else {
                top = stack.pop();
                if (pre != null) {
                    min = Math.min(min, Math.abs(top.val - pre.val));
                }
                //这里忘记让pre=top了，也出现一次错误，要特别注意
                pre = top;
            }
        }
        return min;
    }

}
