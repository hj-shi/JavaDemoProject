package stack;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<Integer> pushList = new ArrayList<>();
        pushList.add(1);
        pushList.add(2);
        pushList.add(3);
        pushList.add(4);
        pushList.add(5);

        ArrayList<Integer> popList = new ArrayList<>();
        popList.add(3);
        popList.add(2);
        popList.add(1);
        popList.add(5);
        popList.add(4);

        boolean result = solution.isPopOrder(pushList, popList);
        System.out.println("result: " + result);
    }
}
