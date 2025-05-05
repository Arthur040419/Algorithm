package Shopee;

import dataStructure.TreeNode;

import java.util.*;

//2025虾皮笔试，编程题第二题
public class Main2 {
    //AC 100%
    public int[][] levelOrder(TreeNode root) {
        /**
         * 思路：
         * 简单的二叉树层序遍历
         */
        if(root==null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> results = new ArrayList<>();
        //初始化队列
        queue.add(root);
        int len = 1;
        while (!queue.isEmpty()){
            len = queue.size();
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                res.add(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            results.add(res);
        }
        int n = results.size();
        int[][] finalResult = new int[n][];
        for (int i = 0; i < n; i++) {
            List<Integer> res = results.get(i);
            int arrayLen = res.size();
            int[] arr = new int[arrayLen];
            for (int j = 0; j < arrayLen; j++) {
                arr[j]=res.get(j);
            }
            finalResult[i]=arr;
        }
        return finalResult;
    }
}
