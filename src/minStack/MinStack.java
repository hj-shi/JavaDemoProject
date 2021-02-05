package minStack;

import java.util.EmptyStackException;
import java.util.Stack;

public class MinStack<T extends Comparable> {
    Stack<T> originStack;
    Stack<T> minValueStack;

    public MinStack() {
        this.originStack = new Stack<>();
        this.minValueStack = new Stack<>();
    }

    public T min() {
        if (!this.minValueStack.isEmpty()) {
            return minValueStack.peek();
        } else {
            throw new EmptyStackException();
        }
    }

    public void push(T element) {
        // 放到原始stack中
        this.originStack.push(element);
        if (minValueStack.isEmpty()) {
            this.minValueStack.push(element);
        } else {
            T minValue = this.minValueStack.peek();
            if (element.compareTo(minValue) < 0 ) {
                this.minValueStack.push(element);
            } else {
                this.minValueStack.push(minValue);
            }
        }
    }

    public T pop() {
        this.minValueStack.pop();
        return this.originStack.pop();
    }
}
