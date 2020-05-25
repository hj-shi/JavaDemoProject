package link;

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
}
