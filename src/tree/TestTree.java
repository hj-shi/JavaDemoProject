package tree;


public class TestTree {

    public static void main(String[] argv) {
        BinaryTree bt = new BinaryTree();

//        Node root = bt.createBinaryTree1();
//        bt.preOrder(root);

//        bt.inOrder(root);
//        bt.postOrder(root);
//        bt.preOrderIter(root);
//        bt.inOrderIter(root);
//        bt.postOrderIter(root);
//        double result = Math.random();
        BinaryTreeNode root1 = bt.createBinaryTree1();
        BinaryTreeNode root2 = bt.createBinaryTree2();
        BinaryTreeNode root3 = bt.createBinaryTree3();

//        boolean result = bt.hasSubtree(root1, root2);
//        System.out.println("二叉树root1包含root2 ？ " + result);
//        BinaryTreeNode newRoot = bt.mirrorRecursively(root3);
//        BinaryTreeNode newRoot = bt.mirroIterally(root3);
//        bt.preOrder(newRoot);

        bt.printBinaryTreeByLevel(root3);
        bt.printBinaryTreeByLevelUseQueue(root3);
    }
}
