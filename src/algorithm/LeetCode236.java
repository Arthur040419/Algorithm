package algorithm;

import dataStructure.TreeNode;

//236.二叉树的最近公共祖先
public class LeetCode236 {
    //我这里有个自己的思路：找到两条到达目标值的路径，用两个集合分别记录到达目标值的路径经过的节点，然后从后往前对比两个集合，找到第一个不同的节点，这个不同节点的后面那个节点就是最近公共祖先
    //这个思路没来得及写，留个坑先。


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
         * 思路：
         * 采用后序遍历，优先处理子节点，这样得到的结果就一定是最深的公共祖先也就是最近公共祖先
         * 对左右子树的处理逻辑如下：
         * 1.在左右子树中寻找目标值（p或q），如果找到目标值，就直接返回，根节点获取左右子树的寻找结果，如果左右子树的返回结果都不为空，说明该根节点就是最近的公共祖先
         * 2.如果已经找到了最近的公共祖先，就直接返回公共祖先节点
         * 3.如果左子树返回结果为空，就返回右子树的返回结果；反之，如果右子树的节点为空，就返回左子树的返回结果
         * 4.如果都为空，说明根节点不是公共祖先节点，直接返回null（实际上这一点已经被包含在第3点了）
         */

        //后序遍历处理子节点
        TreeNode leftRes = null;
        TreeNode rightRes = null;
        if (root.left != null) {
            leftRes = lowestCommonAncestor(root.left, p, q);
        }
        if (root.right != null) {
            rightRes = lowestCommonAncestor(root.right, p, q);
        }
        //如果左右子树的返回结果都不为空，说明当前节点就是最近公共祖先
        if(leftRes!=null&&rightRes!=null){
            return root;
        }
        //处理根节点,如果找到了目标值
        if(root.val==p.val||root.val==q.val) return root;

        if(leftRes==null) return rightRes;
        return leftRes;
    }
}
