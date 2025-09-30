package algorithm;

import dataStructure.TreeNode;

//230.二叉搜索树中第k小的元素
public class LeetCode230 {

    public int kthSmallest(TreeNode root, int k) {
        int count = getCount(root.left);
        if(count==k-1){
            return root.val;
        }else if(count>k-1){
            return kthSmallest(root.left,k);
        }else {
            return kthSmallest(root.right,k-1-count);
        }

    }

    public int getCount(TreeNode root) {
        if (root == null) return 0;
        int left = getCount(root.left);
        int right = getCount(root.right);
        return left + right + 1;
    }

}
