package complexList;

public class Test {
    public static void main(String[] args) {
        ComplexList complexList = new ComplexList();
        ComplexListNode head = complexList.getComplexList();
        ComplexListNode newHead = complexList.clone(head);
        System.out.println("复制结束");
    }
}
