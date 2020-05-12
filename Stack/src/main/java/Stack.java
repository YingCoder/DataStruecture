/**
 * @Author: weizujie
 * @Date: 2020/5/12
 * @Version: 1.0
 * @Github: https://github.com/weizujie
 */
public interface Stack<E> {
    int getSize();

    boolean isEmpty();

    E pop();

    E peek();
}
