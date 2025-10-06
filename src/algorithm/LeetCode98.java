package algorithm;

import dataStructure.TreeNode;

//98.验证二叉搜索树
public class LeetCode98 {

    private TreeNode max;

    public boolean isValidBST(TreeNode root) {
        /**
         * 思路：
         * 首先要知道一个知识点：对于二叉搜索树使用中序遍历，遍历出来的结果一定是递增的。
         * 因此我们就可以通过判断中序遍历的结果是否为递增，从而判断这颗树是否为二叉搜索树
         */

        if (root == null) return true;
        boolean left = isValidBST(root.left);
        if (max != null && root.val <= max.val) {
            return false;
        }
        max = root;
        boolean right = isValidBST(root.right);

        return left && right;

    }

    //复习-2025-09-21
    public boolean isValidBST_Review(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean left = isValidBST_Review(root.left);
        if (max != null && max.val >= root.val) {       //严格大于
            return false;
        }
        max = root;
        boolean right = isValidBST_Review(root.right);

        return left && right;
    }
}

//这个代码存在问题，但是问题还没有找到
class Solution_Error {
    private int maxVal;

    public boolean isValidBST(TreeNode root) {
        /**
         * 思路：
         * 首先要知道一个知识点：对于二叉搜索树使用中序遍历，遍历出来的结果一定是递增的。
         * 因此我们就可以通过判断中序遍历的结果是否为递增，从而判断这颗树是否为二叉搜索树
         */

        //首先初始化最大值，为了方便后面判断节点是否为递增的，将二叉搜索树的最左下角的值（也就是二叉搜索树的最小值）作为初始化的最大值
        TreeNode left = root;
        while (left != null) {
            maxVal = left.val;
            left = left.left;
        }

        //递归调用判断是否为二叉搜索树的方法
        return isValidBSTSolution(root);

    }

    private boolean isValidBSTSolution(TreeNode root) {
        if (root == null) return true;
        boolean left = isValidBSTSolution(root.left);
        //if (root.val > maxVal) {            //2025-09-20找到原，因为这行代码，最开始初始化的最大值为最左下角的节点值，那么在判断时先到达的也是左下角节点，此时节点值和maxVal是相等的
        if (root.val >= maxVal) {       //但是修改成大于等于也没法通过全部测试用例，比如2、2、2
            maxVal = root.val;
        } else {
            return false;
        }
        boolean right = isValidBSTSolution(root.right);

        return left && right;
    }
}
