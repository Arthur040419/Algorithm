package algorithm;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

//199.二叉树的右视图
public class LeetCode199 {
    List<Integer> res = new ArrayList<>();

    //复习-2025-09-29
    public List<Integer> rightSideView(TreeNode root) {
        solution(root,1);
        return res;
    }

    public void solution(TreeNode root, int depth) {
        if (root == null) return;
        if (res.size() < depth) {
            res.add(root.val);
        }
        solution(root.right, depth + 1);
        solution(root.left, depth + 1);
    }

}
