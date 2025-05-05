package algorithm;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

//501.二叉搜索树中的众数
public class LeetCode501 {

    List<Integer> list = new ArrayList<>();
    int maxCount;
    TreeNode pre = null;
    int count;

    public int[] findMode(TreeNode root) {
        /**
         * 思路：
         * 如果是在普通的二叉树中，就只能遍历所有节点，用一个Map集合来统计节点出现的次数，然后返回Map集合中出现频率最高的节点
         * 但是再二叉搜索树中，由于中序遍历的结果是一个递增数组，因此在遍历二叉树的同时就能获取到节点出现的频率。
         * 我们可以维护一个maxCount变量，用于表示最大的频率。
         * 遍历二叉搜索树时，判断当前节点出现频率是否等于maxCount，如果等于，就将当前节点存入结果集中
         * 但是，特别注意，如果当前节点出现的频率已经大于maxCount时，我们需要先清空结果集，因为此时，结果集中所有结果均已失效，需要存入最新的出现频率最高的节点，也就是当前节点
         * 当然，需要使用一个pre指针，方便判断当前节点cur出现的次数，如果pre.val==cur.val，频率就+1，否则频率就重置为1
         */

        maxCount = 1;
        count = 1;
        findModeSolution(root);
        //这个Integer类型集合转换成int数组的方式一定要记住。
//        return list.stream().mapToInt(new ToIntFunction<Integer>() {
//            @Override
//            public int applyAsInt(Integer value) {
//                return value.intValue();
//            }
//        }).toArray();

        //Lambda简化形式
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private void findModeSolution(TreeNode cur) {
        if (cur.left != null) findModeSolution(cur.left);

        if (pre != null) {
            if (cur.val == pre.val) {
                count++;
            } else {
                count = 1;
            }
        }
        if (maxCount == count) {
            list.add(cur.val);
        } else if (maxCount < count) {
            list.clear();
            maxCount = count;
            list.add(cur.val);
        }
        pre = cur;

        if (cur.right != null) findModeSolution(cur.right);
    }
}
