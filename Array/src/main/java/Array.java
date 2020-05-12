
/**
 * @Author: weizujie
 * @Date: 2020/5/12
 * @Version: 1.0
 * @Github: https://github.com/weizujie
 */

public class Array<E> {

    private E[] data;
    // 数组中元素的个数
    // 指向数组中第一个没有元素的位置
    private int size;

    // 构造函数，传入数组的容量 capacity 构造 Array
    public Array(int capacity) {
        // data = new E[capacity];
        data = (E[]) new Object[capacity];
        size = 0;
    }


    // 无参构造，默认数组的容量为 10
    public Array() {
        this(10);
    }


    // 获取数组中的元素个数
    public int getSize() {
        return size;
    }

    // 获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    // 返回数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 向所有元素后添加一个新元素e
    public void addLast(E e) {
        add(size, e);
    }

    // 向所有元素前添加一个新元素e
    public void addFirst(E e) {
        add(0, e);
    }

    // 在第 index 个位置插入一个新元素 e
    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("需要 index >=0 并且 index <= size.");
        }

        if (size == data.length) {
            // throw new IllegalArgumentException("数组已经满了");
            // 数组扩容，旧数组的两倍
            resize(2 * data.length);
        }

        // 从右到左遍历，逐个元素向右挪一位
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;
    }


    // 获取 index 索引位置的元素
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index 非法");
        }
        return data[index];
    }

    // 修改 index 索引位置的元素为 e
    void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index 非法");
        }
        data[index] = e;
    }

    // 查找数组中是否存在元素 e
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            // if (data[i] == e) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    // 查找元素中元素 e 所在的索引，如果不存在则返回 -1
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            // if (data[i] == e) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    // 从数组中删除 index 位置的元素，返回被删除的元素
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index 非法");
        }

        // 从 index 后一位开始，逐个向前挪一位
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }

        size--;
        // 垃圾回收机制，不写这句也行
        // loitering objects != memory leak
        data[size] = null;

        // 当数组删除到一定容量时，数组的容量缩小
        if (size == data.length / 2) {
            resize(data.length / 2);
        }

        return ret;
    }

    // 从数组中删除第一个元素
    public E removeFirst() {
        return remove(0);
    }

    // 从数组中删除最后一个元素
    public E removeLast() {
        return remove(size - 1);
    }

    // 从数组总删除元素 e
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("元素的个数 = %d, 数组的容量 = %d \n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            // 判断 i 是否为最后一个元素
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }


    // 私有方法，用户不能调用这个方法
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

}
