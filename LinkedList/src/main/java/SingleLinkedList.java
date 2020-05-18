/**
 *
 * Single Linked List
 *
 * @Author: weizujie
 * @Date: 2020/5/18
 * @Version: 1.0
 * @Github: https://github.com/weizujie
 */
public class SingleLinkedList<E> {

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

        @Override
        public String toString() {
            return e.toString();
        }

    }

    private Node dummyHead;
    private int size;

    public SingleLinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("超出链表节点范围！");
        }

        Node prevNode = dummyHead;
        for (int i = 0; i < index; i++) {
            prevNode = prevNode.next;
        }

        Node node = new Node(e);
        node.next = prevNode.next;
        prevNode.next = node;
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void remove(int index) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("超出链表节点范围！");
        }

        Node prevNode = dummyHead;
        for (int i = 0; i < index; i++) {
            prevNode = prevNode.next;
        }

        Node delNode = prevNode.next;
        prevNode.next = delNode.next;
        delNode.next = null;
        size--;
    }

    public void removeFirst() {
        remove(0);
    }

    public void removeLast() {
        remove(size);
    }

    public void setVal(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("超出链表节点范围！");
        }

        Node currentNode = dummyHead.next;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        currentNode.e = e;

    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("null");
        return res.toString();
    }


}
