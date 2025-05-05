package algorithm;

import dataStructure.TreeNode;

import java.util.*;

//257.二叉树的所有路径
public class LeetCode257 {
    public List<String> binaryTreePaths(TreeNode root) {
        //path用于记录经过的路径节点
        List<Integer> path = new ArrayList<>();
        //result用于记录所有的路径字符串结果
        List<String> result = new ArrayList<>();
        binaryTreePathsSolution(root, path, result);
        return result;
    }

    private void binaryTreePathsSolution(TreeNode root, List<Integer> path, List<String> result) {
        /**
         * 思路：
         * 递归+回溯
         * 采用前序遍历，当根节点的左右子节点为null时，说明到达了叶子节点，此时可以将path中的节点取出来然后拼成一个字符串存入到result集合中
         * 如果没有到达叶子节点，就递归调用，继续遍历节点
         */

        //前序遍历，先将根节点存入path
        path.add(root.val);

        //递归终止条件，找到叶子节点
        if (root.left == null && root.right == null) {
            //取出path中的节点
//            String res = "";
            //使用StringBuilder可以明显提高速度，原本使用String耗时为10ms，使用StringBuilder后耗时为2ms
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                if (i != path.size() - 1) {
                    res.append(path.get(i) + "->");
                } else {
                    res.append(path.get(i));
                }
            }
            result.add(res.toString());
            return;
        }
        //没有到达叶子节点就继续遍历
        if (root.left != null) {
            binaryTreePathsSolution(root.left, path, result);
            //回溯
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            binaryTreePathsSolution(root.right, path, result);
            path.remove(path.size() - 1);
        }

    }
}

/**
 * 迭代法
 */
class Solution2 {
    /**
     * 迭代法思路：
     * 将节点与到达当前节点的路径一起存入到栈中
     * 处理节点时就将节点和其对应的路径一起弹出
     * 如果该节点是叶子节点，直接将路径存入结果集
     * 如果该节点不是叶子节点，就将其子节点以及子节点的路径存入栈中
     * 重复以上操作，直到栈中元素为空
     */

    //结果集
    private List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null) return result;
        //因为要同时存入节点和路径，因此泛型选择为Object
        Deque<Object> stack = new LinkedList<>();
        StringBuilder path = new StringBuilder();
        path.append(root.val);
        stack.push(root);
        stack.push(path);
        deal(stack);
        return result;
    }

    private void deal(Deque<Object> stack) {
        while (!stack.isEmpty()){
            //弹出栈顶元素
            StringBuilder path = (StringBuilder) stack.pop();
            TreeNode root = (TreeNode) stack.pop();
            //如果是叶子节点
            if(root.left==null&&root.right==null){
                result.add(path.toString());
                continue;
            }
            //如果不是叶子节点
            if(root.left!=null){
                stack.push(root.left);
                stack.push(new StringBuilder(path).append("->"+root.left.val));
            }
            if(root.right!=null){
                stack.push(root.right);
                stack.push(new StringBuilder(path).append("->"+root.right.val));
            }
        }
    }


}
