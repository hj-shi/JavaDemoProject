package switchtest;

import annotations.PasswordUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SwitchTestDemo {
    public static void main(String[] args) {
        try {
            testSwitch(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int testSwitch(int inputNo) throws Exception {
        switch (inputNo) {
            case 1:
                System.out.println("input number is 1");
            case 2:
                System.out.println("input number is 2");
            case 3:
            case 4:
                System.out.println("input number is 3 or 4");
                return 3;
                default:
                    System.out.println("input number is default");
                    throw new Exception();
        }
    }
}
