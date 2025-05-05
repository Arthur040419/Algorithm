package algorithm;

import dataStructure.TreeNode;

//235.二叉搜索树的最近公共祖先
public class LeetCode235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
         * 思路：
         * 同样的思路，学习一下别人的代码
         */
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        return root;

    }


    public TreeNode lowestCommonAncestor_My(TreeNode root, TreeNode p, TreeNode q) {
        /**
         * 思路：
         * 对于二叉搜索数，由于它的节点是有序的，因此如果一个节点n是某两个节点p,q的公共祖先，那么n一定在[p,q]这个区间范围内
         * 并且，如果n在[p,q]范围内，说明n一定是p，q的最近公共祖先
         */

        if (root == null) return root;
        if ((p.val <= root.val && root.val <= q.val) || (q.val <= root.val && root.val <= p.val)) {
            return root;
        }
        TreeNode left = null;
        if (root.left != null) left = lowestCommonAncestor(root.left, p, q);
        if (left != null) return left;

        TreeNode right = null;
        if (root.right != null) right = lowestCommonAncestor(root.right, p, q);
        return right;
    }
}
