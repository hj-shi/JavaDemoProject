package link;

public class Test {
    public static void main(String[] args) {
        MyLink list = new MyLink();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);

//        Node recHead =  list.reverseListRecursively(list.head);
//        Node recHead =  list.reverseListRecursively2(list.head);
//        Node recHead =  list.head;
//        Node recHead = list.reverseIteratively(list.head);
//
//        Node tmp = recHead;
//        while (tmp != null) {
//            System.out.println(tmp.item);
//            tmp = tmp.next;
//        }

//        Node midNode = list.searchMid(list.head);
//        System.out.println("midNode: " + midNode.item);
//
//        Node last2Node = list.findElement(6);
//        System.out.println("last 5th node: " + last2Node.item);

        list.printLinkRec(list.head);
    }
}
