package link;

public class Test {
    public static void main(String[] args) {
        MyLink list = new MyLink();
        list.addNode(2);
        list.addNode(3);
        list.addNode(6);
        list.addNode(9);
        list.addNode(15);
        list.addNode(17);
        list.addNode(19);

//        MyLink list2 = new MyLink();
//        list2.addNode(1);
//        list2.addNode(3);
//        list2.addNode(5);
//        list2.addNode(11);
//        list2.addNode(13);

//        Node recHead =  list.reverseListRecursively(list.head);
//        Node recHead =  list.reverseListRecursively2(list.head);
//        Node recHead =  list.head;
//        Node recHead = list.reverseIteratively(list.head);
//        Node revreseHead = list.getRevertHead(list.head);
//        Node revreseHeadRecur = list.getRevertHeadRecur(list.head);
//
//        Node newHead = list.mergeSortedList(list.head, list2.head);
//        Node newHead = list.mergeSortedListRecursively(list.head, list2.head);
//
//        Node tmp = newHead;
//        while (tmp != null) {
//            System.out.println(tmp.item);
//            tmp = tmp.next;
//        }

//        Node midNode = list.searchMid(list.head);
//        System.out.println("midNode: " + midNode.item);
//
//        Node last2Node = list.findElement(6);
//        System.out.println("last 5th node: " + last2Node.item);

//        list.printLinkRec(list.head);

//        Node tmpHead = new Node(1);
//        Node result = list.reverseListByIter(tmpHead);
//        Node tmp = result;
//        while (tmp != null) {
//            System.out.print(tmp.item + " ");
//            tmp = tmp.next;
//        }

//        Node head1 = new Node(1);
//        Node node1 = new Node(2);
//        Node node2 = new Node(3);
//        Node node3 = new Node(4);
//        Node node4 = new Node(5);
//
//        head1.next = node1;
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//
//        Node head2 = new Node(8);
//        Node node5 = new Node(9);
//        Node node6 = new Node(10);
//
//        head2.next = node5;
//        node5.next = node6;
//        node6.next = node3;
//
////        Node result = list.firstSameNode(head1, head2);
//        Node result = list.getFirstNodeByStack(head1, head2);
//        System.out.println(result.item);


//        Node head1 = new Node(1);
//        Node node1 = new Node(5);
//        Node node2 = new Node(6);
//        Node node3 = new Node(8);
//        Node node4 = new Node(10);
//
//        head1.next = node1;
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//
//
//        Node head2 = new Node(2);
//        Node node21 = new Node(3);
//        Node node22 = new Node(4);
//        Node node23 = new Node(7);
//        Node node24 = new Node(9);
//
//        head2.next = node21;
//        node21.next = node22;
//        node22.next = node23;
//        node23.next = node24;
//
//        Node newList = list.mergeTwoList(head1, head2);
//
//        while (newList != null) {
//            System.out.print(newList.item + " ");
//            newList = newList.next;
//        }

        Node head1 = new Node(1);
        Node node1 = new Node(2);
//        Node node2 = new Node(3);
//        Node node3 = new Node(4);
//        Node node4 = new Node(5);

//        head1.next = node1;
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;

        Node result = list.getLastNodeK(head1, 3);
        System.out.println("result: " + (result == null ? "null" : result.item));
//        if (result == null) {
//            System.out.println("result is null");
//        } else {
//            System.out.println("result: " + (result == null ? "null" : result.item));
//        }

    }
}
