/**
 * @Author: weizujie
 * @Date: 2020/5/21
 * @Version: 1.0
 * @Github: https://github.com/weizujie
 */
public class ArrayStack {


    private int[] stack;
    private int maxSize;
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public ArrayStack() {
        this(10);
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int e) {

        if (isFull()) {
            throw new IllegalArgumentException("The stack is full.");
        }

        top++;

        stack[top] = e;

    }

    public void pop() {

        if (isEmpty()) {
            throw new RuntimeException("The stack is empty.");
        }

        top--;
    }

    public int peek() {

        if (isEmpty()) {
            throw new RuntimeException("The stack is empty.");
        }

        return stack[top];
    }


}
