package tree;

import java.util.Random;

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
//        bt.postOrderIter(root);
//        double result = Math.random();

        Random random = new Random(12);
        int ran1 = random.nextInt(10);
        System.out.println(ran1);

        Random random2 = new Random();
        int ran2 = random2.nextInt(10);
        System.out.println(ran2);

        double rand3 = random.nextDouble();
        System.out.println(rand3);

    }
}
