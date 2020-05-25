package tree;

public class TestTree {

    public static void main(String[] argv) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        BinaryTree bt = new BinaryTree();

        Node root = bt.createBinaryTree(arr);
//        bt.preOrder(root);

//        bt.inOrder(root);
//        bt.postOrder(root);
//        bt.preOrderIter(root);
//        bt.inOrderIter(root);
        bt.postOrderIter(root);

    }
}
