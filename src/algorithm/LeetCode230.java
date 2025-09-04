package algorithm;

import dataStructure.TreeNode;

//230.二叉搜索树中第 K 小的元素
public class LeetCode230 {

    public int kthSmallest(TreeNode root, int k) {
        /**
         * 思路：
         * 首先要明白二叉搜索树的特点，二叉搜索树的所有子树都满足：左子树的所有节点<=根节点<=右子树的所有节点
         * 基于这个特性，我们可以确定每一个根节点是第几小，比如有一个根节点，它的左子树共有3个节点，那么这个根节点在整个二叉搜索树就是第4小
         * 所以，回到题目，要想获得二叉搜索树的第k小的数，只需要基于上面的思路来实现
         * 首先统计左右子树的节点个数L、R，
         * 如果L=k-1，那么根节点本身就是第k小的节点
         * 如果L>k-1，那么说明第k小的节点在左子树里面，直接递归寻找左子树中第k个小的节点即可
         * 如果L<k-1，那么说明第k小的节点在右子树里面，直接递归寻找右子树第k-L-1个小的节点即可
         */

        int L = getNodeCount(root.left);
        if(L==k-1){
            return root.val;
        }else if(L>k-1){
            return kthSmallest(root.left,k);
        }else {
            return kthSmallest(root.right,k-L-1);
        }

    }

    //获取某个树的节点个数
    public int getNodeCount(TreeNode node) {
        if(node==null){
            return 0;
        }
        //算上本身
        int result = 1;
        if (node.left != null) {
            result += getNodeCount(node.left);
        }
        if (node.right != null) {
            result += getNodeCount(node.right);
        }

        return result;
    }

}
