package algorithm;

import dataStructure.TreeNode;

//450.删除二叉搜索树中的节点
public class LeetCode450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        /**
         * 思路：
         * 如果找到了要删除的节点root，处理方法有以下几种情况：
         * 1.该节点的左右子节点都为空，直接删除该节点
         * 2.该节点的左子节点为空，用右子节点替换该节点
         * 3.该节点的右子节点为空，用左子节点替换该节点
         * 4.该节点的左右子节点都不为空，先将左节点交给右子树的左下角的节点作为左子节点，然后用该节点(root)的右子节点替换该节点(root)
         */

        if (root == null) return null;
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                //将左节点交给右子树的左下角的节点作为左子节点
                cur.left = root.left;

                //删除根节点，用根节点的右子节点替换根节点
                root = root.right;
            }
        }

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }

}
