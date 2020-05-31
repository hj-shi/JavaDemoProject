package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    public BinaryTreeNode createBinaryTree1() {

        BinaryTreeNode root3 = new BinaryTreeNode(2);
        root3.setLeft(new BinaryTreeNode(4));
        root3.setRight(new BinaryTreeNode(7));

        BinaryTreeNode root2 = new BinaryTreeNode(8);
        root2.setLeft(new BinaryTreeNode(9));
        root2.setRight(root3);

        BinaryTreeNode root = new BinaryTreeNode(8);
        root.setLeft(root2);
        root.setRight(new BinaryTreeNode(7));
        return root;
    }

    public BinaryTreeNode createBinaryTree2() {

        BinaryTreeNode root = new BinaryTreeNode(8);
        root.setLeft(new BinaryTreeNode(7));
        root.setRight(new BinaryTreeNode(2));
        return root;
    }

    public BinaryTreeNode createBinaryTree3() {
        BinaryTreeNode root = new BinaryTreeNode(8);

        BinaryTreeNode root1 = new BinaryTreeNode(6);

        BinaryTreeNode root2 = new BinaryTreeNode(10);

        BinaryTreeNode root3 = new BinaryTreeNode(7);
        BinaryTreeNode root4 = new BinaryTreeNode(4);
        BinaryTreeNode root5 = new BinaryTreeNode(11);

        root5.setLeft(new BinaryTreeNode(12));
        root5.setRight(new BinaryTreeNode(13));

        root4.setLeft(new BinaryTreeNode(2));

        root3.setLeft(root4);

        root2.setLeft(new BinaryTreeNode(9));
        root2.setRight(root5);

        root1.setLeft(new BinaryTreeNode(5));
        root1.setRight(root3);


        root.setLeft(root1);
        root.setRight(root2);

        return root;
    }



    // 先序遍历 （递归)
    public void preOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // 中序遍历（递归）
    public void inOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    // 后续遍历 （递归）
    public void postOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    // 前序遍历（循环方式）
    public void preOrderIter(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                System.out.print(curr.data + " ");
                stack.push(curr);
                curr = curr.left;
            } else {
                BinaryTreeNode node = stack.pop();
                curr = node.right;
            }
        }
    }

    // 中序遍历（循环方式）
    public void inOrderIter(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                BinaryTreeNode node = stack.pop();
                System.out.print(node.data + " ");
                curr = node.right;
            }
        }
    }

    // 后续遍历 （循环方式）
    public void postOrderIter(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode curr;
        BinaryTreeNode pPre = null;
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

    // 查找一个二叉树是不是另一个二叉树的字结构
    public boolean hasSubtree(BinaryTreeNode root1, BinaryTreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            result = doesTree1HaveTree2(root1, root2);

            if (!result) {
                result = hasSubtree(root1.left, root2);
            }
            if (!result) {
                result = hasSubtree(root1.right, root2);
            }
        }

        return result;
    }

    // 找到相同的根节点后，判断是否相同
    public boolean doesTree1HaveTree2(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }

        if (root1.data != root2.data) {
            return false;
        }

        return doesTree1HaveTree2(root1.left, root2.left) && doesTree1HaveTree2(root1.right, root2.right);
    }

    // 求树的镜像（递归）
    public BinaryTreeNode mirrorRecursively(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        BinaryTreeNode tmpNode;
        tmpNode = root.left;
        root.left = root.right;
        root.right = tmpNode;
        mirrorRecursively(root.left);
        mirrorRecursively(root.right);
        return root;
    }

    // 求树的镜像（循环）
    public BinaryTreeNode mirroIterally(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                // 先进行左右子树对换操作
                BinaryTreeNode tmp;
                tmp = curr.left;
                curr.left = curr.right;
                curr.right = tmp;
                // 操作完成入栈
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                curr = curr.right;
            }
        }
        return root;

    }

    // 按层级打印二叉树 (使用两个栈实现队列）
    public void printBinaryTreeByLevel(BinaryTreeNode root) {
        if (root == null) {
            System.out.println("二叉树为空，请检查输入是否正确！");
            return;
        }
        BinaryTreeNode currNode;
        Stack<BinaryTreeNode> inStack = new Stack<>();
        Stack<BinaryTreeNode> outStack = new Stack<>();

        inStack.push(root);
        while (!inStack.isEmpty() || !outStack.isEmpty() ) {
            while (!inStack.isEmpty()) {
                BinaryTreeNode tmpNode = inStack.pop();
                outStack.push(tmpNode);
            }

            while (!outStack.isEmpty()) {
                currNode = outStack.pop();
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    inStack.push(currNode.left);
                }
                if (currNode.right != null) {
                    inStack.push(currNode.right);
                }

            }
        }
    }

    // 按层级打印二叉树 (直接使用Java Queue）
    public void printBinaryTreeByLevelUseQueue(BinaryTreeNode root) {
        if (root == null) {
            System.out.println("二叉树为空，请检查输入是否正确！");
            return;
        }
        BinaryTreeNode currNode;
        Queue<BinaryTreeNode> queue = new LinkedList<>();  // 这个地方要注意，Queue是一个接口，具体的实现是 LinkedList

        queue.offer(root);
        while (!queue.isEmpty()) {
            currNode = queue.poll();
            System.out.print(currNode.data + " ");

            if (currNode.left != null) {
                queue.offer(currNode.left);
            }
            if (currNode.right != null) {
                queue.offer(currNode.right);
            }
        }
    }

}
