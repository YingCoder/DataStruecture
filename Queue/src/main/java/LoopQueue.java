/**
 * @Author: weizujie
 * @Date: 2020/5/21
 * @Version: 1.0
 * @Github: https://github.com/weizujie
 */
public class LoopQueue {

    private int[] list;
    private int front;
    private int rear;

    public LoopQueue(int capacity) {
        this.front = 0;
        this.rear = 0;
        this.list = new int[capacity];
    }


    public LoopQueue() {
        this(10);
    }


    public void enQueue(int e) {

        if ((rear + 1) % list.length == front) {
            throw new IllegalArgumentException("The queue is full");
        }

        // 队尾元素入队
        list[rear] = e;
        rear = (rear + 1) % list.length;
    }

    public void deQueue() {

        if (rear == front) {
            throw new IllegalArgumentException("The queue is full");
        }

        // 队首元素出队，将 front 指向原来的队首的下一位
        front = (front + 1) % list.length;
    }
}
