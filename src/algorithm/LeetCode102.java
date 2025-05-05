package algorithm;

import dataStructure.TreeNode;

import java.util.*;

//102.二叉树的层序遍历
public class LeetCode102 {
    //将结果集设为成员变量，这样方便递归时来访问结果集
    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        //方法1：迭代法
        //List<List<Integer>> result = solution1(root);
        //方法2：递归法
        solution2(root,0);
        return res;
    }

    /**
     * 迭代法
     *
     * @param root
     * @return
     */
    private List<List<Integer>> solution1(TreeNode root) {
        /**
         * 思路：
         * 利用一个队列来存放节点元素，并用一个变量len来记录每一层的节点个数
         * 每处理一个节点，len减1
         * 当len变为0时，说明当前层的所有节点已经遍历完毕，接着统计当前队列中的元素个数，更新len
         * 新的len就是下一层要处理的节点个数
         * 一直按上面的步骤处理，直到队列中的元素为空
         */

        if (root == null) return Collections.EMPTY_LIST;
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> arr = new ArrayList<>();
            //获取每一层要遍历的节点个数
            int len = queue.size();
            while (len != 0) {
                //len不为0就代表当前层的节点没遍历完
                TreeNode top = queue.poll();
                //将当前节点数据存入结果集
                arr.add(top.val);
                //并将当前节点的子节点存入队列中
                if (top.left != null) queue.offer(top.left);
                if (top.right != null) queue.offer(top.right);
                //别忘了让len-1
                len--;
            }
            result.add(arr);
        }

        return result;
    }


    /**
     * 递归法
     * @param root
     * @return
     */
    private void solution2(TreeNode root,Integer deep) {
        /**
         * 思路：
         * 在方法中维护一个deep变量，用于表示当前的深度
         * 而由于题目中存储不同层的数据时用的是不同的结果集，即：第一层用第一个集合，第二层用第二个集合
         * 题目需要返回的结果就是集合的集合，这里假定为List<List<Integer> res
         * 因此可以使用deep来找到当前遍历的节点需要存到的集合，即如果是第deep层的节点，那么集合就是res.get(deep-1)
         * 而每当res的大小小于deep的时候，就说明此时遍历到新的一层了，需要添加新的集合
         *
         */

        //如果根节点不为空，层数加1
        if(root==null) return;
        deep++;

        //如果结果集的大小小于深度，说明当前是新的一层，需要添加新的集合
        if(res.size()<deep){
            res.add(new ArrayList<>());
        }

        //将当前遍历的节点存入该层对应的集合中
        res.get(deep-1).add(root.val);

        //递归处理当前节点的子节点
        solution2(root.left,deep);
        solution2(root.right,deep);
    }

}
