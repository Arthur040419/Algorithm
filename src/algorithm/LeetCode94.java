package algorithm;

import dataStructure.TreeNode;

import java.util.*;

//94.二叉树的中序遍历
public class LeetCode94 {

    /**
     * 递归法
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal_1(TreeNode root) {
        /**
         * 二叉树的中序遍历 顺序为 左中右
         */

        List<Integer> result = new ArrayList<>();
        //递归调用中序遍历方法
        inOrder_1(root, result);
        return result;
    }

    private void inOrder_1(TreeNode root, List<Integer> result) {
        //递归终止条件
        if (root == null) {
            return;
        }

        //遍历左子树
        inOrder_1(root.left, result);
        //将根节点存入队列
        result.add(root.val);
        //遍历右子树
        inOrder_1(root.right, result);
    }

    //复习-2025-09-18
    public List<Integer> inorderTraversal_Review(TreeNode root) {
        if(root==null){
            return Collections.EMPTY_LIST;
        }
        List<Integer> result = new ArrayList<>();
        inorder_Review(root,result);
        return  result;
    }

    public void inorder_Review(TreeNode root,List<Integer> result){
        if (root.left!=null){
            inorder_Review(root.left,result);
        }
        result.add(root.val);
        if(root.right!=null){
            inorder_Review(root.right,result);
        }
    }

    //复习2-2025-09-29
    public List<Integer> inorderTraversal_Review2(TreeNode root) {
        if(root==null){
            return Collections.EMPTY_LIST;
        }
        List<Integer> result = new ArrayList<>();
        inorder_Review2(root,result);
        return result;
    }

    public void inorder_Review2(TreeNode root,List<Integer> result){
        if(root.left!=null){
            inorder_Review2(root.left,result);
        }
        result.add(root.val);
        if(root.right!=null){
            inorder_Review2(root.right,result);
        }
    }


    /**
     * 迭代法
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        /**
         * 中序遍历的迭代法比较特殊，不能从沿用前序遍历迭代法的思路
         */

        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        //cur指针用来表示当前访问到的指针
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            //如果当前指针不为空，就将当前节点存入栈中
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                //如果当前指针为空，就取出栈中元素进行处理
                TreeNode top = stack.pop();
                result.add(top.val);
                cur = top.right;

            }
        }
        return result;
    }

    /**
     * 统一迭代法
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal_All(TreeNode root) {
        //双端队列不允许存入null值，所以这里用stack
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            //弹出栈顶元素
            TreeNode top = stack.pop();
            if (top != null) {
                //如果栈顶元素不为null，代表后面的元素不需要处理，而是要对元素的子节点进行遍历
                TreeNode cur = stack.pop();
                //存入右节点
                if (cur.right != null) stack.add(cur.right);
                //存入根节点
                stack.add(cur);
                //存入null，代表该节点需要被处理
                stack.add(null);
                //存入左节点
                if (cur.left != null) stack.add(cur.left);
            } else {
                //如果栈顶元素为null，代表后面的元素需要处理
                TreeNode cur = stack.pop();
                result.add(cur.val);
            }

        }
        return result;
    }

    //复习-统一迭代法-2025-09-18
    public List<Integer> inorderTraversal_All_Review(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root!=null) stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node!=null){
                if(node.right!=null){
                    stack.push(node.right);
                }
                stack.push(node);
                stack.push(null);
                if(node.left!=null){
                    stack.push(node.left);
                }

            }else {
                node = stack.pop();
                result.add(node.val);
            }
        }
        return result;
    }

}
