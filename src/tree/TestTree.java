package tree;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        BinaryTreeNode root4 = bt.createBinaryTree4();
        BinaryTreeNode root5 = bt.createBinaryTree5();
        BinaryTreeNode root6 = bt.createBinaryTree6();
        BinaryTreeNode root7 = bt.createBinaryTree7();
        BinaryTreeNode root8 = bt.createBinaryTree8();
        BinaryTreeNode root9 = bt.createBinaryTree9();
        BinaryTreeNode root10 = bt.createBinaryTree10();
        BinaryTreeNode root11 = bt.createBinaryTree11();

//        boolean result = bt.hasSubtree(root1, root2);
//        System.out.println("二叉树root1包含root2 ？ " + result);
//        BinaryTreeNode newRoot = bt.mirrorRecursively(root3);
//        BinaryTreeNode newRoot = bt.mirroIterally(root3);
//        bt.preOrder(newRoot);

//        bt.printBinaryTreeByLevel(root3);
//        bt.printBinaryTreeByLevelUseQueue(root3);
//        bt.printPathEqualToNumber(root4, 19);
//        BinaryTreeNode newHead = bt.turnBinaryTreeToLink(root5);
//        while (newHead != null && newHead.right != null) {
//            System.out.print(newHead.data + " ");
//            newHead = newHead.right;
//        }

//        boolean result = bt.isBalance(root6);
//        System.out.println("isBalance: " + result);
//        boolean result = bt.isSubTreeOf(root7, root8);
//        System.out.println("root8 in root7: " + result);
//        bt.postTraverse(root7);
//        System.out.println();
//        bt.postIter(root7);
//        BinaryTreeNode mirrorNode = bt.mirroIterally(root9);
//        bt.preTraverse(mirrorNode);

//       bt.printTreeHeri(root10);

//        int[] array = { 5, 7, 6, 9, 11, 10, 8};
//        int[] array2 = {7, 4, 6, 5};
//        int[] array3 = { 1 };
//        int[] array4 = { 1, 2};
//        int[] array5 = { 2, 1};
//        int[] array6 = { 1, 2, 3, 4, 5, 6};
//        int[] array7 = {6, 5, 4, 3, 2, 1};
//        int[] array8 = { 1, 2, 5, 8, 4, 9, 6};
//
//        boolean result = bt.isPostOrderListOfBST(array, 0, 6);
//        System.out.println("数组是二叉搜索树的后续遍历序列？ " + result);
//
//
//        boolean result3 = bt.isPostOrderListOfBST(array3, 0, 0);
//        System.out.println("数组是二叉搜索树的后续遍历序列？ " + result3);
//
//        boolean result4 = bt.isPostOrderListOfBST(array4, 0, 1);
//        System.out.println("数组是二叉搜索树的后续遍历序列？ " + result4);
//
//        boolean result5 = bt.isPostOrderListOfBST(array5, 0, 1);
//        System.out.println("数组是二叉搜索树的后续遍历序列？ " + result5);
//
//        boolean result6 = bt.isPostOrderListOfBST(array6, 0, 5);
//        System.out.println("数组是二叉搜索树的后续遍历序列？ " + result6);
//
//        boolean result7 = bt.isPostOrderListOfBST(array7, 0, 5);
//        System.out.println("数组是二叉搜索树的后续遍历序列？ " + result7);
//
//
//        System.out.println("上面都应该 true");
//
//
//        boolean result2 = bt.isPostOrderListOfBST(array2, 0, 3);
//        System.out.println("数组是二叉搜索树的后续遍历序列？ " + result2);
//
//        boolean result8 = bt.isPostOrderListOfBST(array8, 0, 6);
//        System.out.println("数组是二叉搜索树的后续遍历序列？ " + result8);

//        bt.printSumPathOfBST(root4, 22);

//        BinaryTreeNode node = bt.convert(root11);
//        System.out.println("结束");

//        BinaryTreeNode root = new BinaryTreeNode(8);
//        BinaryTreeNode node1 = new BinaryTreeNode(8);
//        BinaryTreeNode node2 = new BinaryTreeNode(7);
//        BinaryTreeNode node3 = new BinaryTreeNode(9);
//        BinaryTreeNode node4 = new BinaryTreeNode(2);
//        BinaryTreeNode node5 = new BinaryTreeNode(4);
//        BinaryTreeNode node6 = new BinaryTreeNode(7);
//
//        root.left = node1;
//        root.right = node2;
//        node1.left = node3;
//        node1.right = node4;
//        node4.left = node5;
//        node4.right = node6;


//        BinaryTreeNode root22 = new BinaryTreeNode(8);
//        BinaryTreeNode node21 = new BinaryTreeNode(8);
//        BinaryTreeNode node22 = new BinaryTreeNode(7);
//        BinaryTreeNode node23 = new BinaryTreeNode(4);
//        root22.left = node21;
//        root22.right = node22;
//        node21.left = node23;

//        boolean isSame = bt.isChildOf(root, root22);
//        System.out.println("is child : " + isSame);


//        BinaryTreeNode root22 = new BinaryTreeNode(1);
//        BinaryTreeNode node21 = new BinaryTreeNode(2);
//        BinaryTreeNode node22 = new BinaryTreeNode(3);
//        BinaryTreeNode node23 = new BinaryTreeNode(4);
//        root22.left = node21;
//        node21.left = node22;
//        node22.left = node23;
//
//        BinaryTreeNode result = bt.getMirrorOfUseIter(root22);
//        System.out.println(result.data);

        int[] array = new int[] {1, 2, 3, 4, 5};
        boolean result = bt.isPostOrderOfBST(array, 0, 4);
        System.out.println("result: hah: " + result);
    }
}
