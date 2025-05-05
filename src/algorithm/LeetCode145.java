package algorithm;

import dataStructure.TreeNode;

import java.util.*;

//145.二叉树的后续遍历
public class LeetCode145 {


    /**
     * 递归法
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal_1(TreeNode root) {
        //二叉树的后续遍历 顺序为：左右中

        List<Integer> result = new ArrayList<>();
        //递归调用后续遍历方法
        postOrder_1(root, result);
        return result;
    }

    private void postOrder_1(TreeNode root, List<Integer> result) {
        //递归终止条件，节点为空
        if (root == null) {
            return;
        }

        //后序遍历
        //遍历左子树
        postOrder_1(root.left, result);
        //遍历右子树
        postOrder_1(root.right, result);
        //将根节点存入队列
        result.add(root.val);

    }

    /**
     * 迭代法
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        //后序遍历的迭代法可以沿用前序遍历迭代法的思路
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        if (root != null) stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            result.add(top.val);
            if (top.left != null) stack.push(top.left);
            if (top.right != null) stack.push(top.right);
            //此时元素的访问顺序为中右左，因此最后需要将结果反转过来才是正确的遍历结果
        }
        Collections.reverse(result);
        return result;
    }


}
