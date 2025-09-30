package algorithm;

import dataStructure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

//114.二叉树展开为链表
public class LeetCode114 {

    public void flatten(TreeNode root) {
        if(root==null) return;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode preNode = null;
        TreeNode curNode = null;
        stack.push(root);
        while (!stack.isEmpty()){
            curNode = stack.pop();
            if(preNode!=null){
                preNode.left=null;
                preNode.right = curNode;
            }
            if(curNode.right!=null){
                stack.push(curNode.right);
            }
            if(curNode.left!=null){
                stack.push(curNode.left);
            }
            preNode = curNode;
        }
    }
}
