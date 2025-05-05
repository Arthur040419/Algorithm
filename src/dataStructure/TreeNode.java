package dataStructure;

//树的节点
public class TreeNode {

    //当前节点的值
    public int val;
    //左节点
    public TreeNode left;
    //右节点
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
