package tree;

import javax.swing.tree.TreeNode;
import java.util.*;

public class BinaryTree {
    BinaryTreeNode linkTail = null;

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

    public BinaryTreeNode createBinaryTree4() {
        BinaryTreeNode root = new BinaryTreeNode(10);

        BinaryTreeNode root1 = new BinaryTreeNode(5);
        root1.setLeft(new BinaryTreeNode(4));
        root1.setRight(new BinaryTreeNode(7));

        root.setLeft(root1);
        root.setRight(new BinaryTreeNode(12));

        return root;
    }

    public BinaryTreeNode createBinaryTree5() {
        BinaryTreeNode root = new BinaryTreeNode(10);

        BinaryTreeNode root1 = new BinaryTreeNode(6);
        root1.setLeft(new BinaryTreeNode(4));
        root1.setRight(new BinaryTreeNode(8));

        BinaryTreeNode root2 = new BinaryTreeNode(14);
        root2.setLeft(new BinaryTreeNode(12));
        root2.setRight(new BinaryTreeNode(16));

        root.setLeft(root1);
        root.setRight(root2);

        return root;
    }


    public BinaryTreeNode createBinaryTree6() {
        BinaryTreeNode root = new BinaryTreeNode(1);

        BinaryTreeNode root1 = new BinaryTreeNode(2);
        root1.setLeft(new BinaryTreeNode(4));
        BinaryTreeNode root2 = new BinaryTreeNode(5);
        root2.setRight(new BinaryTreeNode(6));
        root1.setRight(root2);

        BinaryTreeNode root3 = new BinaryTreeNode(3);
//        BinaryTreeNode root4 = new BinaryTreeNode(7);
//        root4.setRight(new BinaryTreeNode(8));
        root3.setRight(new BinaryTreeNode(7));

        root.setLeft(root1);
        root.setRight(root3);

        return root;
    }

    public BinaryTreeNode createBinaryTree7() {
        BinaryTreeNode root = new BinaryTreeNode(8);

        BinaryTreeNode root1 = new BinaryTreeNode(8);
        root1.setLeft(new BinaryTreeNode(9));
        BinaryTreeNode root2 = new BinaryTreeNode(2);
        root2.setLeft(new BinaryTreeNode(4));
        root2.setRight(new BinaryTreeNode(7));
        root1.setRight(root2);

        root.setLeft(root1);
        root.setRight(new BinaryTreeNode(7));

        return root;
    }

    public BinaryTreeNode createBinaryTree8() {
        BinaryTreeNode root = new BinaryTreeNode(8);

        root.setLeft(new BinaryTreeNode(9));

        BinaryTreeNode root1 = new BinaryTreeNode(2);
        root1.setLeft(new BinaryTreeNode(4));

        root.setRight(root1);

        return root;
    }


    public BinaryTreeNode createBinaryTree9() {
        BinaryTreeNode root = new BinaryTreeNode(1);

        BinaryTreeNode root1 = new BinaryTreeNode(2);
        root1.setLeft(new BinaryTreeNode(4));
        BinaryTreeNode root2 = new BinaryTreeNode(5);
        root2.setRight(new BinaryTreeNode(7));
        root1.setRight(root2);

        root.setLeft(root1);
        root.setRight(new BinaryTreeNode(3));

        return root;
    }


    public BinaryTreeNode createBinaryTree10() {
        BinaryTreeNode root = new BinaryTreeNode(8);

        BinaryTreeNode root1 = new BinaryTreeNode(6);
        root1.setLeft(new BinaryTreeNode(5));
        root1.setRight(new BinaryTreeNode(7));

        BinaryTreeNode root2 = new BinaryTreeNode(10);
        root2.setLeft(new BinaryTreeNode(9));
        root2.setRight(new BinaryTreeNode(11));

        root.setLeft(root1);
        root.setRight(root2);

        return root;
    }

    public BinaryTreeNode createBinaryTree11() {
        BinaryTreeNode root = new BinaryTreeNode(10);

        BinaryTreeNode root1 = new BinaryTreeNode(6);
        root1.setLeft(new BinaryTreeNode(4));
        root1.setRight(new BinaryTreeNode(8));

        BinaryTreeNode root2 = new BinaryTreeNode(14);
        root2.setLeft(new BinaryTreeNode(12));
        root2.setRight(new BinaryTreeNode(16));

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

    // 打印二叉树中最大路径和等于特定值的路径
    public void printPathEqualToNumber(BinaryTreeNode root, int expectedSum) {
        if (root == null) {
            return;
        }


        // 进行栈的初始化，初始化currentSum值
        Stack<BinaryTreeNode> pathStack = new Stack<>();
        int currentSum = 0;

        // 将栈和当前值传入，然后进行递归
        findPath(root, expectedSum, pathStack, currentSum);

    }

    public void findPath(BinaryTreeNode root, int expectedSum, Stack<BinaryTreeNode> path, int currentSum) {

        currentSum += root.data;
        path.push(root);

        if (root.left == null && root.right == null) {
            // 到达叶节点
            if (currentSum == expectedSum) {
                // 输出路径
                Iterator<BinaryTreeNode> stackIterator = path.iterator();
                while (stackIterator.hasNext()) {
                    System.out.print(stackIterator.next().data + " ");
                }
                System.out.println();
            }
        } else if (root.left != null && root.right == null) {
            findPath(root.left, expectedSum,  path, currentSum);
        } else if (root.right != null && root.left == null) {
            findPath(root.right, expectedSum,  path, currentSum);
        } else {
            findPath(root.left, expectedSum,  path, currentSum);
            findPath(root.right, expectedSum,  path, currentSum);
        }

        path.pop();
    }

    // 二叉搜索树转换为双向链表
    public BinaryTreeNode turnBinaryTreeToLink(BinaryTreeNode root) {

//        BinaryTreeNode lastNodeInLink = null;
//        getLink(root， lastNodeInLink); // Java里面不能这么写。。。。。。。。

        getLink(root);

        // 返回头节点
        BinaryTreeNode pHeadOfList = linkTail;
        while (pHeadOfList != null && pHeadOfList.left != null) {
            pHeadOfList = pHeadOfList.left;
        }
        return pHeadOfList;


//        BinaryTreeNode leftConnectNode = null;
//        BinaryTreeNode rightConnectNode = null;
//        if (root.left == null && root.right == null) {
//            return root;
//        } else if (root.left != null && root.right == null) {
//            leftConnectNode = turnBinaryTreeToLink(root.left);
//            leftConnectNode.right = root;
//            root.left = leftConnectNode;
//            return root;
//        } else if (root.right != null && root.left == null) {
//            rightConnectNode = turnBinaryTreeToLink(root.right);
//            rightConnectNode.left = root;
//            root.right = rightConnectNode;
//            return root;
//        } else {
//            leftConnectNode = turnBinaryTreeToLink(root.left);
//            rightConnectNode = turnBinaryTreeToLink(root.right);
//            leftConnectNode.right = root;
//            rightConnectNode.left = root;
//            root.left = leftConnectNode;
//            root.right = rightConnectNode;
//        }

    }

    public void getLink(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        getLink(root.left);
        createList(root);
        getLink(root.right);

    }

    public void createList(BinaryTreeNode currNode) {
        currNode.left = linkTail;
        if (linkTail != null) {
            linkTail.right = currNode;
        }

        linkTail = currNode;
    }

    // 判断二叉树是否平衡
    public boolean isBalance(BinaryTreeNode root) {
        if (root == null) {
            return true;
        }

        return getMaxDepthOfTree(root) != -1;
    }

    private int getMaxDepthOfTree(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = getMaxDepthOfTree(root.left);
        if (leftDepth == -1) {
            return -1;
        }
        int rightDepth = getMaxDepthOfTree(root.right);
        if (rightDepth == -1) {
            return -1;
        }

        return Math.abs(leftDepth - rightDepth) > 1 ? -1 : Math.max(leftDepth, rightDepth) + 1;
    }

    private int getMinDepthOfTree(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = getMinDepthOfTree(root.left);
        int rightDepth = getMinDepthOfTree(root.right);

        return leftDepth <= rightDepth ? leftDepth + 1 : rightDepth + 1;
    }

    public boolean isSubTreeOf(BinaryTreeNode treeA, BinaryTreeNode treeB) {
        if (treeA == null || treeB == null) {
            return false;
        }
        boolean result = false;
        if (treeA.data == treeB.data) {
            // 根节点相同
            result =  hasTheTreeof(treeA.left, treeB.left) && hasTheTreeof(treeA.right, treeB.right);
        }
        if (!result) {
            result = isSubTreeOf(treeA.left, treeB) || isSubTreeOf(treeA.right, treeB);
        }

        return result;
    }

    private boolean hasTheTreeof(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }

        if (root1.data == root2.data) {
            return hasTheTreeof(root1.left, root2.left) && hasTheTreeof(root1.right, root2.right);
        } else {
            return false;
        }
    }

//    public void mirrorTreeIter(BinaryTreeNode root) {
//        if (root == null) {
//            return;
//        }
//
//        Stack<BinaryTreeNode> stack = new Stack<>();
//        BinaryTreeNode current = root;
//        // 标记上一次交换的是哪个
//        BinaryTreeNode previousChangeNode = null;
//        // current 不为null说明还有左孩子没有加入到栈中
//        // stack 不为空说明还要右树的左右未交换
//        while (current != null || !stack.isEmpty()) {
//            while (current != null) {
//                stack.push(current);
//                current = current.left;
//            }
//
//           BinaryTreeNode top = stack.peek();
//
//            if (top.right == previousChangeNode || top.right == null) {
//                BinaryTreeNode tmpNode = top.left;
//                top.left = top.right;
//                top.right = tmpNode;
//                previousChangeNode = top;
//                stack.pop();
//            } else {
//                current = top.right;
//            }
//        }
//    }

    // 前序遍历
    public void preTraverse(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preTraverse(root.left);
        preTraverse(root.right);
    }

    // 中序遍历
    public void inTraverse(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        inTraverse(root.left);
        System.out.print(root.data + " ");
        inTraverse(root.right);
    }

    // 后续遍历
    public void postTraverse(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        postTraverse(root.left);
        postTraverse(root.right);
        System.out.print(root.data + " ");
    }

    // 递归实现前序遍历
    public void preIter(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();

        BinaryTreeNode current = root;

        while (current != null || !stack.isEmpty()) {

            while (current != null) {
                // 先打印后入栈
                System.out.print(current.data + " ");
                stack.push(current);
                current = current.left;
            }

            // 弹出栈顶元素，判断右子树是否为空，不为空则加入
            BinaryTreeNode top = stack.pop();
            if (top.right != null) {
                current = top.right;
            }

        }
    }

    // 递归实现中序遍历
    public void middleIter(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        BinaryTreeNode current = root;

        Stack<BinaryTreeNode> stack = new Stack<>();

        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                BinaryTreeNode top = stack.pop();
                System.out.print(top.data + " ");
                current = top.right;
            }
        }
    }

    // 递归实现后续遍历
    public void postIter(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        BinaryTreeNode current = root;

        Stack<BinaryTreeNode> stack = new Stack<>();

        BinaryTreeNode lastPoped = null; // 这个变量很关键，标记上次弹出的是哪个？不然会死循环了

        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                // 判断栈顶元素是否有右子树
                BinaryTreeNode top = stack.peek();
                if (top.right != null && top.right != lastPoped) {
                    // 有右子树, 入栈，并赋值给 current
                    current = top.right;
                } else {
                    // 无右子树，出栈，打印
                    lastPoped = stack.pop();
                    System.out.print(lastPoped.data + " ");

                }
            }
        }
    }


    public void mirrorIt(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        BinaryTreeNode current = root;
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode lastPop = null;

        while (current != null || stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                BinaryTreeNode top = stack.peek();
                if (top.right != null) {
                    if (top.right != lastPop) {
                        current = top.right;
                    } else {
                        // 出栈，交换左右节点
                        lastPop = stack.pop();
                        BinaryTreeNode tmp = lastPop.left;
                        lastPop.left = lastPop.right;
                        lastPop.right = tmp;
                    }

                } else {
                    // 右子树为空，不交换，直接出栈
                    lastPop = stack.pop();
                }
            }
        }
    }

    public void printTreeHeri(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();

            System.out.print(node.data + " ");

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    /**
     * @param array 待检测数组，默认非空
     * @param start 起始坐标
     * @param end 结束坐标
     * @return
     */
    public boolean isPostOrderListOfBST(int[] array, int start, int end) {
        // 不再判断 array 是否为空
        if (end - start + 1 < 3) {
            return true;
        }

        int root = array[end];

        int newStart = start;
        int newEnd = end - 1;

        // 找到第一个大于root的index
        for (int i = start; i <= end - 1; i++) {
            if (array[i] < root) {
                newStart++;
            } else {
                break;
            }
        }

        // 找到第一个小于root的index
        for (int j = end - 1; j >= start; j--) {
            if (array[j] > root) {
                newEnd--;
            } else {
                break;
            }
        }

        if (newStart - newEnd == 1) {
            // 递归遍历子数组
            if (newStart > end - 1) {
                return isPostOrderListOfBST(array, start, newEnd);
            } else if (newEnd < start) {
                return isPostOrderListOfBST(array, newStart, end -1);
            } else {
                return isPostOrderListOfBST(array, start, newEnd) && isPostOrderListOfBST(array, newStart, end - 1);
            }
        } else {
            return false;
        }

    }

    public void printSumPathOfBST(BinaryTreeNode root, int desiredSum) {
        if (root == null) {
            return;
        }

        // 辅助栈，用于打印路径
        Stack<BinaryTreeNode> stack = new Stack<>();
        // 当前路径和
        int sum = 0;

        // 前序遍历
       visitInorder(root, stack, sum, desiredSum);
    }

    public void visitInorder(BinaryTreeNode root, Stack<BinaryTreeNode> stack, int sum, int desiredSum) {
//        if (root == null) {
//            return;
//        }

        stack.push(root);
        sum += root.data;

        // 叶子节点，判断和是否等于输入
        if (root.left != null) {
            visitInorder(root.left, stack, sum, desiredSum);
        }
        if (root.right != null) {
            visitInorder(root.right, stack, sum, desiredSum);
        }

        if (sum == desiredSum) {
            printPath(stack);
        }
        stack.pop();
    }

    public void printPath(Stack<BinaryTreeNode> stack) {
        Iterator<BinaryTreeNode> iterator = stack.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next().data + " ");
        }
        System.out.println();
    }

    public BinaryTreeNode convert(BinaryTreeNode root) {
        BinaryTreeNode lastNodeInList = convertNode(root, null);

        // lastNodeInList 指向双向链表的尾节点，我们需要返回头节点
        BinaryTreeNode headOfList = lastNodeInList;
        while(headOfList != null && headOfList.left != null) {
            headOfList = headOfList.left;
        }

        return headOfList;
    }

    public BinaryTreeNode convertNode(BinaryTreeNode node, BinaryTreeNode lastNodeInList) {
        if (node == null) {
            return null;
        }

        BinaryTreeNode current = node;

        if (current.left != null) {
            lastNodeInList = convertNode(current.left, lastNodeInList);
        }

        // 左子树里面最小的 left 指向 lastNodeInList
        current.left = lastNodeInList;
        // lastNodeInList 的 right, 指向 current
        if (lastNodeInList != null) {
            lastNodeInList.right = current;
        }
        // lastNodeInList 更新为当前的值
        lastNodeInList = current;

        // 看到这，有点和使用一个栈把中序遍历存起来，从左往右处理是一样的（lastNodeInList 的作用等同于一个栈）
        if (current.right != null) {
            lastNodeInList = convertNode(current.right, lastNodeInList);
        }

        return lastNodeInList;
    }


    public int[] getRightSideViewList(BinaryTreeNode root) {
        int[] result = new int[10];
        if (root == null) return result;
        int index = 0;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        Queue<Integer> indexQueue = new LinkedList<>();
        queue.offer(root);
        indexQueue.offer(index);

        while (!queue.isEmpty()) {
            BinaryTreeNode current = queue.poll();
            int currentIndex = indexQueue.poll();

            // 将出栈的值放入到以层级为下标的数组中
            result[currentIndex] = current.data;

            if (current.left != null || current.right != null) {
                index++;
                if (current.left != null) {
                    queue.offer(current.left);
                    indexQueue.offer(index);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                    indexQueue.offer(index);
                }
            }
        }

        return result;
    }

    public List<Integer> rightSideView(BinaryTreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return new ArrayList<Integer>();
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                BinaryTreeNode current = queue.poll();
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }

                if (i == size - 1) {
                    res.add(current.data);
                }
            }
        }

        return res;
    }

    // 这里不是判断两棵树相不相等，而是判断root2 是不是在root1 中
    public boolean isParentTreeOf(BinaryTreeNode root1, BinaryTreeNode root2) {
        // 退出条件
        if (root2 == null) {
            return true;
        }

        if (root1 == null) {
            return false;
        }

        if (root1.data == root2.data) {
            return isParentTreeOf(root1.left, root2.left) && isParentTreeOf(root1.right, root2.right);
        } else {
            return false;
        }
    }

    public boolean isChildOf(BinaryTreeNode root, BinaryTreeNode target) {
        // 退出条件
        if (root == null || target == null) {
            return false;
        }
        if (root.data == target.data) {
            if (isParentTreeOf(root, target)) {
                return true;
            }
        }

        return isChildOf(root.left, target) || isChildOf(root.right, target);

    }

    public BinaryTreeNode getMirrorOf(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        BinaryTreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        getMirrorOf(root.left);
        getMirrorOf(root.right);

        return root;
    }

//    public void setMirrorOf(BinaryTreeNode root) {
//        // 退出条件
//        if (root == null || (root.left == null && root.right == null)) {
//            return;
//        }
//
//        // 交换 左右孩子
//        BinaryTreeNode tmp = root.left;
//        root.left = root.right;
//        root.right = tmp;
//
//        // 递归左右孩子
//        setMirrorOf(root.left);
//        setMirrorOf(root.right);
//    }

    public BinaryTreeNode getMirrorOfUseIter(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            if (node != null && (node.left != null || node.right != null)) {
                BinaryTreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return root;
    }

    public boolean isPostOrderOfBST(int[] array, int left, int right) {
        // 退出条件
        if (array.length == 1) {
            return true;
        }

        int lastIndex = right;
        int leftIndex = left;
        int rightIndex = lastIndex - 1;
        while (array[leftIndex] < array[lastIndex]) {
            if (leftIndex >= right) {
                break;
            }
            leftIndex++;
        }

        while (array[rightIndex] > array[lastIndex]) {
            if (rightIndex <= left) {
                break;
            }
            rightIndex--;
        }

        if (leftIndex > rightIndex) {
            // 分为了两部分
            return isPostOrderListOfBST(array, left, leftIndex) &&
                    isPostOrderListOfBST(array, rightIndex, right);
        } else {
            return false;
        }
    }

}
