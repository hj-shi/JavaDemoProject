package complexList;

public class ComplexList {
    public ComplexListNode getComplexList() {
        ComplexListNode A = new ComplexListNode(1, null, null);
        ComplexListNode B = new ComplexListNode(2, null, null);
        ComplexListNode C = new ComplexListNode(3, null, null);
        ComplexListNode D = new ComplexListNode(4, null, null);
        ComplexListNode E = new ComplexListNode(5, null, null);
        A.next = B;
        A.sibling = C;
        B.next = C;
        B.sibling = E;
        C.next = D;
        D.next = E;
        D.sibling = B;

        return A;
    }

    // 复制一个复杂链表
    public ComplexListNode clone(ComplexListNode head) {
        if (head == null) {
            return null;
        }

        // 复制next
        copyElementByNext(head);
        // 处理sibling
        handleSiblings(head);
        // 将链表拆分为两个
        ComplexListNode newHead = splitCopiedList(head);

        return newHead;
    }

    // 首先在原链表每个节点后面复制一个新的节点，如 A -> B -> C 复制为 A -> A1 -> B -> B1
    public void copyElementByNext(ComplexListNode head) {
        ComplexListNode node = head;
        while (node != null) {
            ComplexListNode newNode = new ComplexListNode(node.value, node.next, null);
            node.next = newNode;
            node = newNode.next;
        }
    }

    // 处理新复制节点的sibling
    public void handleSiblings(ComplexListNode head) {
        ComplexListNode node = head;

        while (node != null) {
            ComplexListNode copyNode = node.next;
            ComplexListNode nodeSibling = node.sibling;
            ComplexListNode copyNodeSibling = nodeSibling != null ? nodeSibling.next : null;
            copyNode.sibling = copyNodeSibling;
            node = copyNode.next;
        }
    }

    // 拆分链表为2个，并返回新复制链表的头节点
    public ComplexListNode splitCopiedList(ComplexListNode head) {
        ComplexListNode node = head;
        ComplexListNode newHead = head.next;
        ComplexListNode newNode = newHead;
        while (node != null) {
            node.next = newNode.next;
            node = newNode.next;

            newNode.next = node != null ? node.next : null;
            newNode = node != null ? node.next : null;
        }

        return newHead;
    }
}
