package p222;

import p22.Test2;

public class Test22 extends Test2 {
    public static void main(String[] args) {
        Test2 test2 = new Test2();
//        test2.clone();
        Test22 test22 = new Test22();
        try {
            test22.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

class AnotherClass  {
    public static void main(String[] args) {
        Test22 test2 = new Test22();
//        try {
//            test2.clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
    }
}
