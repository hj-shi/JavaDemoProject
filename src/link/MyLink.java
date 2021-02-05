package link;

import java.util.Stack;

public class MyLink {
    Node head = null; // 头节点
    // 向链表中插入数据
    public void addNode(int item) {
        Node newNode = new Node(item); // 实例化一个节点
        if (head == null) {
            head = newNode;
            return;
        }

        // 在链表尾部添加
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }

    // 删除第index个节点
    public boolean deleteNode(int index) {
        if (index < 1 || index > length() ) {
            return false;
        }
        if (index == 1) {
            head = head.next;
            return true;
        }
        int i = 1;
        Node preNode = head;
        Node curNode = preNode.next;
        while (curNode != null) {
            if (i == index) {
                preNode.next = curNode.next;
                return true;
            }
            preNode = curNode;
            curNode = curNode.next;
            i++;
        }
        return false;
    }

    public int length() {
        int length = 0;
        Node tmp = head;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        return length;
    }

    // 链表反转 （递归实现）
    public Node reverseListRecursively(Node head) {
        Node curNode = head;
        if (curNode != null) {
            Node nextNode = curNode.next;
            if (nextNode != null) {
                if (nextNode.next != null) {
                    curNode =  nextNode;
                    nextNode = nextNode.next;
                    reverseListRecursively(curNode);
                }
                nextNode.next = curNode;
                curNode.next = null;
                return curNode;
            }
        }
        return curNode;
    }

    public Node reverseListRecursively2(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newNode = reverseListRecursively2(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }

    public Node reverseIteratively(Node head) {
        Node rHead = head;
        Node curNode = head;
        Node preNode = null;
        while (curNode != null) {
            Node nextNode = curNode.next;
            if (nextNode == null) {
                rHead = curNode;
            }
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return rHead;
    }

    public Node searchMid(Node head) {
        Node p =  head;
        Node q = head;
        while (p != null && p.next != null && p.next.next != null) {
            p = p.next.next;
            q = q.next;
        }
        return q;
    }

    // 查找倒数第k个元素
    public Node findElement(int k) {
        if (length() < k) {
            return null;
        }

        Node p = head;
        Node q = head;
        int i = 0;


        while(i < k && p != null) {
            p = p.next;
            i++;
        }

        while (p != null) {
            p = p.next;
            q = q.next;
        }
        return q;
    }

    // 从尾到头输出单链表
    public void printLinkRec(Node head) {
        Node p = head;
        if (p != null) {
            printLinkRec(p.next);
            System.out.println(p.item);
        }
    }

    // 循环实现单链表反转
    public Node getRevertHead(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node currNode = head;
        Node prevNode = null;
        while (currNode != null) {
            Node tmpNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = tmpNode;
        }
        return prevNode;
    }

    // 递归实现单链表反转
    public Node getRevertHeadRecur(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node lastNode = getRevertHeadRecur(head.next);
        head.next.next = head;
        head.next = null;
        return lastNode;
    }

    // 合并两个有序单链表
    public Node  mergeSortedList(Node head1, Node head2) {
        Node newHead = null;
        Node currNode = null;

        while (head1 != null && head2 != null) {
            if (head1.item <= head2.item) {
                if (newHead == null) {
                    newHead = head1;
                    currNode = newHead;
                } else {
                    currNode.next = head1; // 这里有问题，newHead也要往后移
                    currNode = currNode.next;
                }
                head1 = head1.next;
            } else {
                if (newHead == null) {
                    newHead = head2;
                    currNode = newHead;
                } else {
                    currNode.next = head2;
                    currNode = currNode.next;
                }
                head2 = head2.next;
            }
        }

        if (head1 != null) {
            if (newHead == null) {
                newHead = head1;
            } else {
                currNode.next = head1;
            }

        }

        if (head2 != null) {
            if (newHead == null) {
                newHead = head2;
            } else {
                currNode.next = head2;
            }
        }

        return newHead;
    }

    // 递归合并两个有序链表
    public Node mergeSortedListRecursively(Node head1, Node head2) {
        if (head1 != null && head2 != null) {
            if (head1.item <= head2.item) {
                head1.next = mergeSortedListRecursively(head1.next, head2);
                return head1;
            } else {
                head2.next = mergeSortedListRecursively(head1, head2.next);
                return head2;
            }
        } else if (head1 == null && head2 != null) {
            return head2;
        } else if (head1 != null && head2 == null) {
            return head1;
        } else {
            return null;
        }
    }

        // 反转 1 -> 2 -> 3 -> 4  --->   4  -> 3 -> 2 -> 1
        // 递归方式实现
        public Node reverse(Node head) {
            // 退出条件
            if (head == null || head.next == null )  {
               return head;
            }
            Node newNode = reverse(head.next);
            // 回溯阶段，比如回到了倒数第二个节点，它知道后一个节点
            // 回到了倒数第三个节点，第三个节点
            if (head.next != null) {
                head.next.next = head;
                head.next = null;
            }

            return newNode;
        }

        // 两个链表的第一个公共节点
        public Node firstSameNode(Node list1, Node list2) {
            if (list1 == null || list2 == null) {
                return null;
            }

            int length1 = 0;
            Node tmpNode = list1;
            while (tmpNode != null) {
                length1++;
                tmpNode = tmpNode.next;
            }

            int length2 = 0;
            tmpNode = list2;
            while (tmpNode != null) {
                length2++;
                tmpNode = tmpNode.next;
            }

            Node beginNode = null;
            int step = 0;

            if (length1 > length2) {
                // 第一个链表比较长
                step = length1 - length2;
                beginNode = list1;
                tmpNode = list2;
            } else {
                // 第二个链表比较长
                step = length2 - length1;
                beginNode = list2;
                tmpNode = list1;

            }

            while (step > 0) {
                beginNode = beginNode.next;
                step--;
            }

            while (tmpNode != null) {
                if (tmpNode.item == beginNode.item) {
                    return tmpNode;
                }
                tmpNode = tmpNode.next;
                beginNode = beginNode.next;
            }

            return null;
        }

        // 使用辅助栈的方式
        public Node getFirstNodeByStack(Node list1, Node list2) {
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();

            // 将 list1 中的节点放入 stack1 中
            Node tmp1 = list1;
            while (tmp1 != null) {
                stack1.push(tmp1);
                tmp1 = tmp1.next;
            }

            // 将 list2 中的节点放入 stack1 中
            Node tmp2 = list2;
            while (tmp2 != null) {
                stack2.push(tmp2);
                tmp2 = tmp2.next;
            }

            Node result = null;
            Node currentNode1 = stack1.pop();
            Node currentNode2 = stack2.pop();
            while (currentNode1.item == currentNode2.item) {
                result = currentNode1;
                currentNode1 = stack1.pop();
                currentNode2 = stack2.pop();
            }

            return result;
        }


        public Node mergeTwoList(Node list1, Node list2) {
            if (list1 == null) return list2;
            if (list2 == null) return list1;

            Node currentNode1 = list1;
            Node currentNode2 = list2;

            Node newList = null;

            if (list1.item <= list2.item) {
                // 链表1中的值较小
                newList = list1;
                currentNode1 = list1.next;
            } else {
                newList = list2;
                currentNode2 = list2.next;
            }

            Node currentNode = newList;

            while (currentNode1 != null && currentNode2 != null) {
                if (currentNode1.item <= currentNode2.item) {
                    // 链表1中的值较小
                    currentNode.next = currentNode1;
                    currentNode1 = currentNode1.next;
                } else {
                    currentNode.next = currentNode2;
                    currentNode2 = currentNode2.next;
                }
                currentNode = currentNode.next;
            }

            // list1 有剩余
            while (currentNode1 != null) {
                currentNode.next = currentNode1;
                currentNode1 = currentNode1.next;
                currentNode = currentNode.next;
            }

            // list2 有剩余
            while (currentNode2 != null) {
                currentNode.next = currentNode2;
                currentNode2 = currentNode2.next;
                currentNode = currentNode.next;
            }

            return newList;
        }

        public Node reverseListByIter(Node list) {
            if (list == null || list.next == null) return list;

            Node currentNode = list;
            Node nextNode = currentNode.next;
            currentNode.next = null;

            while (nextNode.next != null) {
                // 暂时保存 nextNode 的下一个节点
                Node tmpNode = nextNode.next;
                // 将 nextNode 的下一个节点指向当前节点
                nextNode.next = currentNode;
                // 将当前节点的替换为当前节点的下一个
                currentNode = nextNode;
                // 将
                nextNode = tmpNode;

            }
            // 最后把next指回当前节点
            nextNode.next = currentNode;
            return nextNode;
        }

        // 获取倒数第k个节点，为了符合人们的习惯k=1 表示获取尾节点）
        public Node getLastNodeK(Node list, int k) {
            if (list == null || k <= 0) return null;
            int index = k;

            Node pointer1 = list;
            Node pointer2 = list;
            // 将 pointer1 先往前走k步
            while ( index > 0) {
                // 链表本身长度小于k
                if (pointer1 == null) {
                    return null;
                }
                pointer1 = pointer1.next;
                index--;
            }

            while (pointer1 != null) {
                pointer1 = pointer1.next;
                pointer2 = pointer2.next;
            }

            return pointer2;
        }

    }
