/**
 * Java 实现数组
 *
 * @Author: weizujie
 * @Date: 2020/5/12
 * @Version: 1.0
 * @Github: https://github.com/weizujie
 */
public class Array<E> {

    private E[] data;
    // 元素的个数，指向数组中第一个没有元素的位置
    private int size;

    // 无参构造，默认数组容量为 10
    public Array() {
        this(10);
    }

    // 有参构造，传入 capacity，表示数组的容量
    public Array(int capacity) {
        // 根据 capacity 构造 Array
        data = (E[]) new Object[capacity];
        size = 0;
    }

    // 获取元素个数
    public int getSize() {
        return size;
    }

    // 获取数组容量
    public int getCapacity() {
        return data.length;
    }

    // 数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 插入新的元素, index -> 要插入的位置, e -> 新的元素
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("需要 index >=0 并且 index <= size.");
        }

        // 数组满了，需要扩容
        if (size == data.length) {
            resize(2 * data.length);
        }

        // 从右到左遍历，逐个元素向右移动一位
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    // 查找元素，找到返回索引，找不到返回 -1
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    // 传入索引值，删除元素
    public void remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("需要 index >=0 并且 index <= size.");
        }
        // 从 index 的后一位开始，逐个元素向左移动一位
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
    }

    // 知道了元素具体的值，删除元素
    public void removeElement(E e) {
        // 先找到要删除的元素的索引
        int index = find(e);
        // 如果这个元素存在
        if (index != -1) {
            // 再删除
            remove(index);
        }
    }

    // 根据索引获取元素
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index 非法");
        }
        return data[index];
    }

    // 根据索引修改元素
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index 非法");
        }
        data[index] = e;
    }

    // 数组扩容
    private void resize(int newCapacity) {
        // 创建一个新的数组
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            // 旧数组的值赋给新数组
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("size: %d, capacity: %d \n", size, data.length));
        stringBuilder.append('[');

        for (int i = 0; i < size; i++) {
            stringBuilder.append(data[i]);
            // 判断 i 是否为最后一个元素
            if (i != size - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
