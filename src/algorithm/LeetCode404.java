package algorithm;

import dataStructure.TreeNode;

//404.左叶子之和
public class LeetCode404 {
    public int sumOfLeftLeaves(TreeNode root) {
        /**
         * 思路：
         * 采用后序遍历，先获取左右子树的左叶子节点之和，然后相加就是根节点的左叶子节点之和
         * 要判断一个节点是不是左叶子节点，只能根据它的父节点来判断。
         * 如果该节点是其父节点的左节点，且该节点是叶子节点，说明这个节点就是左叶子节点
         * 如果是左叶子节点，直接返回这个节点的值
         * 如果不是，就递归调用方法获取左树和右树的左叶子节点之和
         */

        //如果是节点为空，或者节点为叶子节点，直接返回0
        if(root==null) return 0;
        if(root.left==null&&root.right==null) return 0;

        //判断左节点是否是左叶子节点，如果是，就返回左节点的值和左节点的右子树的左叶子节点之和
        if(root.left!=null&&root.left.left==null&&root.left.right==null){
            return root.left.val+sumOfLeftLeaves(root.right);
        }

        //如果左节点不是左叶子节点，就返回左子树和右子树的左叶子节点之和
        return sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right);
    }
}
