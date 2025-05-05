package algorithm;

import dataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//144.二叉树的前序遍历
public class LeetCode144 {

    /**
     * 递归法
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal_1(TreeNode root) {
        /**
         * 二叉树的前序遍历 顺序为中左右
         */
        List<Integer> result = new ArrayList<>();
        //递归调用前序遍历方法
        preOrder_1(root, result);
        //返回遍历结果
        return result;
    }

    private void preOrder_1(TreeNode root, List<Integer> result) {
        //递归终止条件
        if (root == null) {
            //如果节点为空就直接返回
            return;
        }

        //将根节点存入队列
        result.add(root.val);
        //遍历左子树
        preOrder_1(root.left, result);
        //遍历右子树
        preOrder_1(root.right, result);
    }

    /**
     * 迭代法
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        /**
         * 思路：
         * 迭代法是利用栈来实现的，迭代法进行前序遍历的过程如下
         * 先将根节点存入栈，完成初始化
         * 当栈不为空时，就将栈顶元素弹出，并存入队列。
         * 然后将栈顶元素的左右节点存入栈，这里注意，要先将右节点入栈，再将左节点入栈，因为栈是先进后出的，左节点后入栈才能先遍历左子树
         * 一直重复以上步骤，直到栈中元素全部弹出
         */
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        //初始化
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            //弹出栈顶元素
            TreeNode top = stack.pop();
            result.add(top.val);
            //将右节点压入栈
            if (top.right != null) stack.push(top.right);
            //将左节点压入栈
            if (top.left != null) stack.push(top.left);
        }

        return result;
    }

}
