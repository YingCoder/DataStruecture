/**
 * @Author: weizujie
 * @Date: 2020/5/15
 * @Version: 1.0
 * @Github: https://github.com/weizujie
 */
public class LinkedListQueue<E> {

    class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

    }

    private Node head;
    private Node rear;
    private int size;

    public LinkedListQueue() {
        head = null;
        rear = null;
        size = 0;
    }

    public void enQueue(E e) {
        if (rear == null) {
            rear = new Node(e);
            head = rear;
        } else {
            rear.next = new Node(e);
            rear = rear.next;
        }
        size++;
    }

    public void deQueue() {
        if (size == 0) {
            throw new IllegalArgumentException("Queue is empty.");
        }

        Node delNode = head;
        head = head.next;
        delNode.next = null;
        if (head == null) {
            rear = null;
        }
        size--;
    }

}
