/**
 * @Author: weizujie
 * @Date: 2020/5/13
 * @Version: 1.0
 * @Github: https://github.com/weizujie
 */
public class MyQueue {

    private int[] data;
    private int front;
    private int rear;

    public MyQueue() {
        this(10);
    }

    public MyQueue(int capacity) {
        data = new int[capacity];
        front = 0;
        rear = 0;
    }

    public void enQueue(int e) {
        if ((rear + 1) % data.length == front) {
            throw new IllegalArgumentException("Queue is full.");
        }
        data[rear] = e;
        rear = (rear + 1) % data.length;
    }

    public int deQueue() {
        if (rear == front) {
            throw new IllegalArgumentException("Queue is full.");
        }
        int deQueueElement = data[front];
        front = (front + 1) % data.length;
        return deQueueElement;
    }

    public void output() {
        for (int i = front; i != rear; i = (i + 1) % data.length) {
            System.out.println(data[i]);
        }
    }
}
