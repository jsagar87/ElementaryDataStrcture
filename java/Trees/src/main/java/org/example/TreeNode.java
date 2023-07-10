package org.example;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode (int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    TreeNode (int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void Insert(int val, TreeNode root) {
        if (root == null) {
            root = new TreeNode(val);
        }
        if (val <= root.val) {
            Insert(val, root.left);
        }
    }

    @Override
    public String toString() {
        return "\t\t("+ this.val +") \n" +
                "\t\t/ \\\n" +
                "\t      ("+ this.left.val +")("+ this.right.val +")";
    }
}
