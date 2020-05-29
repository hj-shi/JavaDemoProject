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

        MyLink list2 = new MyLink();
        list2.addNode(1);
        list2.addNode(3);
        list2.addNode(5);
        list2.addNode(11);
        list2.addNode(13);

//        Node recHead =  list.reverseListRecursively(list.head);
//        Node recHead =  list.reverseListRecursively2(list.head);
//        Node recHead =  list.head;
//        Node recHead = list.reverseIteratively(list.head);
//        Node revreseHead = list.getRevertHead(list.head);
//        Node revreseHeadRecur = list.getRevertHeadRecur(list.head);

        Node newHead = list.mergeSortedList(list.head, list2.head);

        Node tmp = newHead;
        while (tmp != null) {
            System.out.println(tmp.item);
            tmp = tmp.next;
        }

//        Node midNode = list.searchMid(list.head);
//        System.out.println("midNode: " + midNode.item);
//
//        Node last2Node = list.findElement(6);
//        System.out.println("last 5th node: " + last2Node.item);

//        list.printLinkRec(list.head);
    }
}
