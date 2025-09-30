package algorithm;

import dataStructure.TreeNode;

import java.util.HashMap;

//437.路径总和III
public class LeetCode437 {

    public int pathSum(TreeNode root, int targetSum) {
        /**
         * 思路：
         * 深度优先搜索（dfs）+前缀和
         * 在遍历每一个节点时，都记录每一个节点的前缀和
         * 假设当前节点node的前缀和为curr，如果存在前缀和为currPre-targetSum，说明存在一条路径到当前节点的和为目标值targetSum
         */

        HashMap<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);
        return dfs(root, prefix, 0L, targetSum);
    }


    public int dfs(TreeNode node, HashMap<Long, Integer> prefix, Long curr, int targetSum) {

        if (node == null) {
            return 0;
        }
        curr = node.val + curr;

        int ret = prefix.getOrDefault(curr - targetSum, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        ret += dfs(node.left, prefix, curr, targetSum);
        ret += dfs(node.right, prefix, curr, targetSum);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

        return ret;
    }

    //复习-2025-09-29
    public int dfs_Review(TreeNode node, HashMap<Long, Integer> prefix, Long curr, int targetSum) {
        if (node == null) return 0;
        curr += node.val;
        int res = prefix.getOrDefault(curr-targetSum, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        res += dfs_Review(node.left, prefix, curr, targetSum);
        res += dfs_Review(node.right, prefix, curr, targetSum);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);
        return res;
    }
}
