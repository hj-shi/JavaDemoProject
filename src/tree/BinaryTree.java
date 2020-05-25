package tree;

import java.util.Stack;

public class BinaryTree {
    public Node root; // 根节点
    public static int index;

    public Node createBinaryTree(int[] arr) {
        Node root = null;
//        if (index < arr.length) {
//            root = new Node(arr[index]);
//            index++;
//            root.setLeft(createBinaryTree(arr));
//            index++;
//            root.setRight(createBinaryTree(arr));
//        }
        root = new Node(1);

        Node root4 = new Node(4);
        root4.setRight(new Node(7));

        Node root6 = new Node(6);
        root6.setLeft(new Node(8));

        Node root2 = new Node(2);
        root2.setLeft(root4);

        Node root3 = new Node(3);
        root3.setLeft(new Node(5));
        root3.setRight(root6);

        root.setLeft(root2);
        root.setRight(root3);
        return root;
    }

    // 先序遍历
    public void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // 中序遍历
    public void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    // 后续遍历
    public void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    // 前序遍历（循环方式）
    public void preOrderIter(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                System.out.print(curr.data + " ");
                stack.push(curr);
                curr = curr.left;
            } else {
                Node node = stack.pop();
                curr = node.right;
            }
        }
    }

    // 中序遍历（循环方式）
    public void inOrderIter(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                Node node = stack.pop();
                System.out.print(node.data + " ");
                curr = node.right;
            }
        }
    }

    public void postOrderIter(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node curr;
        Node pPre = null;
        stack.push(root);

        while (!stack.isEmpty()) {
            curr = stack.peek();
            if ((curr.left == null && curr.right == null) || (pPre != null && (curr.left == pPre || curr.right == pPre))) {
                System.out.print(curr.data);
                stack.pop();
                pPre = curr;
            } else {
                if (curr.right != null) {
                    stack.push(curr.right);
                }
                if (curr.left != null) {
                    stack.push(curr.left);
                }
            }
        }
    }
}
