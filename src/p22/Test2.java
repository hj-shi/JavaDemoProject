package p22;

import p2.MyObject2;

public class Test2 extends MyObject2 {
    public static void main(String[] args[]) {
        MyObject2 obj = new MyObject2();
//        obj.clone();

        Test2 tObj = new Test2();
        try {
            tObj.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
