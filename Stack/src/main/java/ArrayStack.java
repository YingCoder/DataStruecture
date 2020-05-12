/**
 * @Author: weizujie
 * @Date: 2020/5/12
 * @Version: 1.0
 * @Github: https://github.com/weizujie
 */
public class ArrayStack<E> implements Stack<E> {


    Array<E> array;


    public ArrayStack() {
        array = new Array<E>();
    }

    public ArrayStack(int capacity) {
        array = new Array<E>(capacity);
    }

    public int getSize() {
        return array.getSize();
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    public void push(E e) {
        array.addLast(e);
    }

    public E pop() {
        return array.removeLast();
    }

    public E peek() {
        return array.getLast();
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Stack: ");
        stringBuilder.append('[');
        for (int i = 0; i < array.getSize(); i++) {
            stringBuilder.append(array.get(i));
            if (i != array.getSize() - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("] top");
        return stringBuilder.toString();
    }
}
