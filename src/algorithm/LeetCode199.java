package algorithm;

import dataStructure.TreeNode;

import java.util.*;

//199.二叉树的右视图
public class LeetCode199 {

    //官解
    public List<Integer> rightSideView(TreeNode root) {
        /**
         * 思路：
         * 深度优先搜索，先遍历右子树，再遍历左子树，对于每一层遍历到的第一个节点就是右视图的其中一个节点
         *
         */

        if (root == null) {
            return Collections.emptyList();
        }

        //存储每一层的最右边的节点
        Map<Integer, Integer> rightSideViewInDepth = new HashMap<>();

        //未遍历的节点栈
        Deque<TreeNode> nodeStack = new LinkedList<>();
        //未遍历的节点对应的深度
        Deque<Integer> depthStack = new LinkedList<>();

        //最大深度
        int max_depth = -1;

        //初始化
        nodeStack.push(root);
        depthStack.push(0);

        while (!nodeStack.isEmpty()) {
            TreeNode curNode = nodeStack.pop();
            int curDepth = depthStack.pop();

            if (!rightSideViewInDepth.containsKey(curDepth)) {
                rightSideViewInDepth.put(curDepth, curNode.val);
            }

            max_depth = Math.max(max_depth, curDepth);

            if (curNode.left != null) {
                nodeStack.push(curNode.left);
                depthStack.push(curDepth + 1);
            }

            if (curNode.right != null) {
                nodeStack.push(curNode.right);
                depthStack.push(curDepth + 1);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= max_depth; i++) {
            result.add(rightSideViewInDepth.get(i));
        }

        return result;

    }

    //官解的代码实现的很啰嗦，实际上代码可以很简洁
    public List<Integer> rightSideView_optimize(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        dfs(root, 1, result);
        return result;
    }

    public void dfs(TreeNode root, int depth, List<Integer> result) {
        if (depth > result.size()) {
            result.add(root.val);
        }

        if (root.right != null) {
            dfs(root.right, depth + 1, result);
        }

        if (root.left != null) {
            dfs(root.left, depth + 1, result);
        }

    }

    //复习-2025-09-20
    public List<Integer> rightSideView_Review(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        getRightView_Review(root,1,result);
        return result;
    }

    public void getRightView_Review(TreeNode root,int depth,List<Integer> result){
        if(root==null){
            return;
        }
        if(depth>result.size()){
            result.add(root.val);
        }

        getRightView_Review(root.right,depth+1,result);
        getRightView_Review(root.left,depth+1,result);
    }

}
