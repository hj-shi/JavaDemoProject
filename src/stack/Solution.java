package stack;

import java.util.List;
import java.util.Stack;

public class Solution {
    public boolean isPopOrder(List<Integer> pushList, List<Integer> popList) {
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        int pushIndex = 0;

        while (popIndex < popList.size()) {
            if (stack.isEmpty()) {
                // 入栈
                if (pushIndex < pushList.size()) {
                    stack.push(pushList.get(pushIndex));
                    pushIndex++;
                } else {
                    break;
                }

            } else {
                // 判断栈顶元素是否是目标元素
                if (stack.peek() == popList.get(popIndex)) {
                    // 是目标元素，弹出
                    stack.pop();
                    popIndex++;
                } else {
                    // 不是目标元素
                    // 入栈
                    if (pushIndex < pushList.size()) {
                        stack.push(pushList.get(pushIndex));
                        pushIndex++;
                    } else {
                        break;
                    }
                }
            }
        }

        return popIndex == popList.size();
    }
}
