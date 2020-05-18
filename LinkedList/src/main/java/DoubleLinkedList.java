/**
 * Double Linked List
 *
 * @Author: weizujie
 * @Date: 2020/5/18
 * @Version: 1.0
 * @Github: https://github.com/weizujie
 */
public class DoubleLinkedList<E> {

    class Node {
        public E e;
        public Node next;
        public Node prev;

        public Node(E e, Node next, Node prev) {
            this.e = e;
            this.next = next;
            this.prev = prev;
        }

        public Node(E e) {
            this(e, null, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }

    }


    private Node dummyHead;
    private int size;

    public DoubleLinkedList() {
        dummyHead = new Node(null, null, null);
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
        node.prev = prevNode;
        prevNode.next = node;
        prevNode.prev = node;

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

        if (delNode.next != null) {
            delNode.next.prev = prevNode;
            delNode.prev = null;
            prevNode.next = delNode.next;
            delNode.next = null;
            size--;
        } else {
            // 如果删除的是最后一个节点
            prevNode.next = null;
            delNode.prev = null;
        }


    }

    public void removeFirst() {
        remove(0);
    }

    public void removeLast() {
        remove(size - 1);
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
