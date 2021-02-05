package complexList;

public class ComplexListNode {
    int value;
    ComplexListNode next;
    ComplexListNode sibling;

    public ComplexListNode(int value, ComplexListNode next, ComplexListNode sibling) {
        this.value = value;
        this.next = next;
        this.sibling = sibling;
    }
}
