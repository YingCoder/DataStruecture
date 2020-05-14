/**
 * @Author: weizujie
 * @Date: 2020/5/13
 * @Version: 1.0
 * @Github: https://github.com/weizujie
 */
public class LinkedList<E> {

    private class Node {
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


    // 指向链表头的指针
    // private Node head;
    private Node dummyHead;
    // 指向链表中最后一个元素的下一个位置
    private int size;


    public LinkedList() {
        // head = null;
        dummyHead = new Node(null, null);
        size = 0;
    }

    // 获取链表中元素的个数
    public int getSize() {
        return size;
    }

    // 返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 向链表第 index (0-based) 个位置添加新的元素
    // 在链表中间添加新的元素
    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index 非法");
        }
//        if (index == 0) {
//            addFirst(e);
//        } else {
        // prev 指向新节点插入之后的前一个节点
        // Node prev = head;
        Node prev = dummyHead;
        // for (int i = 0; i < index - 1; i++) {
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        // 创建要插入的元素
        Node node = new Node(e);
        // 首先让 node 指向 prev 的下一个节点
        node.next = prev.next;
        // 再让 prev 指向 node 节点
        prev.next = node;

        // 优雅的写法
        // prev.next = new Node(e, prev.next);

        size++;

    }

    // 在链表头添加新的元素
    public void addFirst(E e) {
        // Node node = new Node();
        // node.next = head;
        // head = node;
        //  size++;

        add(0, e);
    }

    // 在链表尾添加新的元素
    public void addLast(E e) {
        add(size, e);
    }

    // 获取链表第 index(0-based) 个元素
    // 这个操作在链表中不常用，只做练习用
    public E get(int index) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index 非法");
        }

        // 因为只需要获取元素，所有从 dummyHead 的下一个节点开始遍历
        Node currentNode = dummyHead.next;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.e;
    }

    // 获取链表第一个元素
    public E getFirst() {
        return get(0);
    }


    // 获取链表最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    // 更新第 index 个位置的元素为 e
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index 非法");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    // 删除元素
    public E remove(int index) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index 非法");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    // 删除第一个节点
    public E removeFirst() {
        return remove(0);
    }

    // 删除最后一个节点
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }

}
