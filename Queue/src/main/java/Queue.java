/**
 * @Author: weizujie
 * @Date: 2020/5/13
 * @Version: 1.0
 * @Github: https://github.com/weizujie
 */
public interface Queue<E> {

    void enqueue(E e);

    E dequeue();

    E getFront();

    int getSize();

    boolean isEmpty();

}
