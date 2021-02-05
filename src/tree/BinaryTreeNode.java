package tree;

public class BinaryTreeNode {
    public BinaryTreeNode left;
    public BinaryTreeNode right;
    int data;
    public BinaryTreeNode(int data) {
        this.data = data;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }
}
