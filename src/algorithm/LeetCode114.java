package algorithm;

import dataStructure.TreeNode;

import javax.swing.plaf.InsetsUIResource;
import java.util.Deque;
import java.util.LinkedList;

//114.二叉树展开为链表
public class LeetCode114 {

    public void flatten(TreeNode root) {

        /**
         * 思路：
         * 最简单的思路就是先直接前序遍历，将遍历结果存到一个集合中，再将这个集合转换成链表，这种方法就不在这展开了。
         * 这种简单的方法遍历和展开是分开来进行的，先遍历后展开。
         *
         * 而还有一种思路可以在遍历的同时进行展开。
         * 上面的方法之所以遍历和展开不能同时进行，是因为在展开时，节点的右子树的信息就会丢失，因此只要能够保存右子树的节点信息，那么遍历和展开就能同时进行。
         * 可以用一个栈来存储没有被遍历的节点，这样就可以解决右子树节点丢失问题
         *
         */

        if (root == null) {
            return;
        }

        Deque<TreeNode> nodeStack = new LinkedList<>();
        //前驱节点
        TreeNode prev = null;
        nodeStack.push(root);
        while (!nodeStack.isEmpty()) {
            TreeNode curNode = nodeStack.pop();

            if (prev != null) {
                prev.left = null;
                prev.right = curNode;
            }

            if (curNode.right != null) {
                nodeStack.push(curNode.right);
            }

            if (curNode.left != null) {
                nodeStack.push(curNode.left);
            }

            //别忘了修改前驱节点为当前节点
            prev = curNode;
        }

    }

    //复习-2025-09-20
    public void flatten_Review(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode prev = null;
        TreeNode cur = null;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            if (prev != null) {
                prev.left = null;
                prev.right = cur;
            }
            if(cur.right!=null){
                stack.push(cur.right);
            }
            if(cur.left!= null){
                stack.push(cur.left);
            }
            prev = cur;
        }

    }
}
