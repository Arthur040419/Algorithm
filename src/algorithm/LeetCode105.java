package algorithm;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//105.从前序与中序遍历序列构造二叉树
public class LeetCode105 {

    HashMap<Integer,Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /**
         * 思路：
         * 可以使用递归，首先通过前序遍历preorder可以确定第一个元素就是根节点，然后根据这个根节点就可以将中序遍历inorder切割成两个数组，也就是两个子树中序遍历数组
         * 再接着根据这两个数组的元素个数来切割preorder，也可以得到两个子树的前序遍历数组，然后就可以再次用这两个子树的前序遍历数组和中序遍历数组来构造子树。
         * 例如：
         * preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
         * 首先根据前序遍历可以直到这棵树的根节点是3，然后就可以将中序遍历切割成[9],[15,20,7]这两个子树的中序遍历
         * 再由子树的中序遍历反过来切割前序遍历：左子树有1个节点，所以只从原前序遍历数组的根节点往后只需取一个元素[9]
         * 右子树有3个节点，所以取为[20,15,7]
         * 再递归构造preorder = [9],inorder = [9]子树和preorder = [20,15,7],inorder = [15,20,7]子树
         */

        if (preorder == null || preorder.length == 0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return buildTreeWithIndex(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }

    //范围是包前包后
    public TreeNode buildTreeWithIndex(int[] preorder, int[] inorder, int preorder_start, int preorder_end, int inorder_start, int inorder_end) {
        if (preorder_start > preorder_end) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preorder_start]);

        //切割数组,这里可以使用哈希表优化
//        int rootIndex = inorder_start;
//        for (; rootIndex < inorder.length; rootIndex++) {
//            if (inorder[rootIndex] == preorder[preorder_start]) {
//                break;
//            }
//        }
        int rootIndex = map.get(preorder[preorder_start]);

        int leftSize = rootIndex-inorder_start;
        int rightSize = inorder_end-rootIndex;

        root.left = buildTreeWithIndex(preorder,inorder,preorder_start+1,preorder_start+leftSize,inorder_start,rootIndex-1);
        root.right = buildTreeWithIndex(preorder,inorder,preorder_start+leftSize+1,preorder_end,rootIndex+1,inorder_end);

        return root;
    }
}
