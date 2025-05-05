package algorithm;

import dataStructure.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//106.从中序与后序遍历序列构造二叉树
public class LeetCode106 {

    private Map<Integer,Integer> map = new HashMap<>();

    //耗时2ms
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        /**
         * 参考别人的代码：
         * 使用首尾索引来分割数组，避免了创建新数组导致的耗时
         */

        //先将中序遍历数组的值及其索引存入Map，方便后序寻找对应数据的索引

        for (int i = 0; i <inorder.length; i++) {
            map.put(inorder[i],i);
        }
        //这里的索引范围是左闭右开的
        return buildTreeSolution(inorder,0,inorder.length,postorder,0,postorder.length);

    }

    private TreeNode buildTreeSolution(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
        //如果没有元素，直接返回null
        if(inBegin>=inEnd) return null;

        //获取根节点
        int rootVal = postorder[postEnd-1];
        TreeNode root = new TreeNode(rootVal);
        //获取根节点在中序遍历中的位置
        int index = map.get(rootVal);
        //切割中序遍历
        int leftInEnd = index;
        int rightInBegin = index+1;

        //切割后序遍历
        int leftPostEnd = postBegin+leftInEnd-inBegin;
        int rightPostBegin = leftPostEnd;

        //递归获取左右子树的根节点
        root.left = buildTreeSolution(inorder,inBegin,leftInEnd,postorder,postBegin,leftPostEnd);
        root.right = buildTreeSolution(inorder,rightInBegin,inEnd,postorder,rightPostBegin,postEnd-1);

        return root;
    }


    //以下代码是我自己写的，由于每次递归都要创建新的数组，所以耗时很大，并且空间占用也高，上面的代码参考了别人的代码，用首尾索引来代替创建新数组，耗时比较低。
    //耗时7ms
    public TreeNode buildTree_My(int[] inorder, int[] postorder) {
        /**
         * 思路：
         * 要做这道题首先要明白如何根据两个顺序构造一个唯一的二叉树
         * 有两种情况：1.前序遍历+中序遍历 2.后序遍历+中序遍历
         *
         * 这里用到的就是后序遍历+中序遍历
         * 具体思路为：
         * 首先从后序遍历中获取到树的根节点，然后用这个根节点去将中序遍历切割成左子树的中序遍历和右子树的中序遍历
         * 然后根据左子树中序遍历的节点数和右子树中序遍历的节点数去切割后序遍历，将后序遍历切割成左子树的后序遍历和右子树的后序遍历
         * 重复以上步骤，就能逐步还原出一个完整二叉树
         *
         * 这里还需要注意的是切割时的区间范围，采用左闭右开，还是左闭右闭，这个是要在递归中固定好的，不然会导致切割混乱
         * 这里采用左闭右开
         */

        if(inorder==null||postorder==null||inorder.length==0||postorder.length==0) return null;
        //如果是叶子节点
        if(inorder.length==1||postorder.length==1) return new TreeNode(inorder[0]);
        //从后序遍历中获取根节点
        int rootVal = postorder[postorder.length-1];
        TreeNode root = new TreeNode(rootVal);

        //获取根节点在中序遍历中的位置
        int index = 0;
        while (inorder[index]!=rootVal){
            index++;
        }
        //切割中序遍历，左闭右开
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, index);
        int[] rightInorder = Arrays.copyOfRange(inorder, index + 1, inorder.length);

        //然后再切割后序遍历
        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, leftInorder.length);
        int[] rightPostorder = Arrays.copyOfRange(postorder, leftPostorder.length, postorder.length - 1);

        //递归获取左右子树的根节点
        root.left = buildTree(leftInorder,leftPostorder);
        root.right = buildTree(rightInorder,rightPostorder);

        return root;
    }


}
