/**
 * @Author: weizujie
 * @Date: 2020/5/13
 * @Version: 1.0
 * @Github: https://github.com/weizujie
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array<E>(capacity);
    }

    public ArrayQueue() {
        array = new Array<E>();
    }


    public void enqueue(E e) {
        array.addLast(e);
    }

    public E dequeue() {
        return array.removeFirst();
    }

    public E getFront() {
        return array.getFirst();
    }

    public int getSize() {
        return array.getSize();
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            // 判断 i 是否为最后一个元素
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }
}
