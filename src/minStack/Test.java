package minStack;

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
//        MinStack<Integer> minStack = new MinStack();
//
//        minStack.push(3);
//        System.out.println("min 函数返回值： " + minStack.min());
//        minStack.push(4);
//        System.out.println("min 函数返回值： " + minStack.min());
//        minStack.push(2);
//        System.out.println("min 函数返回值： " + minStack.min());
//        minStack.push(1);
//        System.out.println("min 函数返回值： " + minStack.min());
//
//        minStack.pop();
//        System.out.println("min 函数返回值： " + minStack.min());
//        minStack.pop();
//        System.out.println("min 函数返回值： " + minStack.min());
//
//        minStack.push(0);
//        System.out.println("min 函数返回值： " + minStack.min());
//
        int[] pushList = {1, 2, 3, 4, 5};
        int[] popList = {4, 5, 3, 2, 1};
        int[] popList2 = {4, 3, 5, 1, 2};
        boolean result = isPopOfPush(pushList, popList2);
        System.out.println("第二个序列是第一个序列的弹出序列的判断结果：" + result);

    }


    public static boolean isPopOfPush(int[] pushList, int[] popList) {
//        int popIndex = 0;
        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i < pushList.length; i++) {
//            if (pushList[i] != popList[popIndex]) {
//                stack.push(pushList[i]);
//            } else {
//                popIndex++;
//            }
//        }
//        boolean result = false;
//        int pushIndex = 0;

//        for (int i = 0; i < popList.length; i++) {
//            if (!stack.isEmpty() && stack.peek() == popList[i]) {
//                stack.pop();
//            } else {
//                while (stack.isEmpty() || (stack.peek() != popList[i] && pushIndex < pushList.length)) {
//                    stack.push(pushList[pushIndex++]);
//                }
//
//                if (!stack.isEmpty() && stack.peek() == popList[i]) {
//                    stack.pop();
//                } else {
//                    break;
//                }
//            }



//            while (pushIndex < pushList.length) {
//                if (stack.isEmpty() || stack.peek() != popList[i]) {
//                    stack.push(pushList[pushIndex++]);
//                } else {
//                    stack.pop();
//                    break;
//                }
//            }

//            if (!stack.isEmpty() && stack.peek() == popList[i]) {
//                stack.pop();
//            }
//        }
//
//        if (stack.isEmpty()) {
//            return  true;
//        } else {
//            return false;
//        }
        int popIndex = 0;
        int pushIndx = 0;
        boolean result = false;
        while (popIndex < popList.length) {
            while (stack.isEmpty() || stack.peek() != popList[popIndex]) {
                if (pushIndx == pushList.length) {
                    break;
                }

                stack.push(pushList[pushIndx]);
                pushIndx++;
            }

            if (stack.peek() != popList[popIndex]) {
                break;
            }

            stack.pop();
            popIndex++;
        }

        if (stack.empty() && popIndex == popList.length) {
            result = true;
        }

        return result;
    }
}
