/**
 * @Author: weizujie
 * @Date: 2020/5/13
 * @Version: 1.0
 * @Github: https://github.com/weizujie
 */
public class LoopQueue<E> implements Queue<E> {


    private E[] data;
    // 指向队首所在的索引
    private int front;
    // 指向最后一个元素的下一个位置，即新元素入队的位置
    private int tail;
    // 元素的个数
    private int size;


    public LoopQueue(int capacity) {
        // 循环队列，要浪费一个空间，用来判断队列是否已满 ->  (队尾下标+1) % 数组长度 = 队首下标
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    // 入队
    public void enqueue(E e) {
        // 判断队列是否满
        if ((tail + 1) % data.length == front) {
            resize(2 * getCapacity());
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    // 出队
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }

        return ret;


    }

    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return data[front];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return front == tail;
    }

    // 可以装载元素的个数， -1 的原因是：循环队列要浪费一个空间
    public int getCapacity() {
        return data.length - 1;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            // 判断 i 是否为最后一个元素
            if ((i + 1) % data.length != tail) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }
}
