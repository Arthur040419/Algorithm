import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //输入二叉树的前序遍历数组和中序遍历数组，输出后续遍历
        int[] pre = {1, 2, 3, 4};
        int[] inorder = {4, 3, 2, 1};
        //预期结果：2，4，5，3，1
        List<Integer> result = fun(pre, inorder, 0, pre.length, 0, inorder.length);
        System.out.println(result.toString());
    }

    public static List<Integer> fun(int[] pre, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart == preEnd) {
            return Collections.EMPTY_LIST;
        }
        if (preStart + 1 == preEnd) {
            List<Integer> result = new ArrayList<>();
            result.add(pre[preStart]);
            return result;

        }
        int inorderMid = 0;
        for (int i = inStart; i < inEnd; i++) {
            if (inorder[i] == pre[preStart]) {
                inorderMid = i;
                break;
            }
        }
        int leftLen = inorderMid - inStart;


        List<Integer> result = new ArrayList<>();
        //后序遍历左子树
        result.addAll(fun(pre, inorder, preStart + 1, preStart + 1 + leftLen, inStart, inorderMid));
        //后序遍历右子树
        result.addAll(fun(pre, inorder, preStart + 1 + leftLen, preEnd, inorderMid, inEnd));
        //根节点
        result.add(pre[preStart]);
        return result;
    }

}
