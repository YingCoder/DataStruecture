package stack;

/**
 * @Author: weizujie
 * @Date: 2020/5/13
 * @Version: 1.0
 * @Github: https://github.com/weizujie
 */
public interface Stack<E> {

    void push(E e);

    E pop();

    E peek();

}
