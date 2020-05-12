/**
 * @Author: weizujie
 * @Date: 2020/5/12
 * @Version: 1.0
 * @Github: https://github.com/weizujie
 */
public class ArrayTest {

    public static void main(String[] args) {
        Array array = new Array(2);
        array.add(0, 0);
        array.add(1, 1);
        array.add(2, 2);
        array.add(3, 3);
        array.add(4, 4);
        array.add(5, 1234);

        array.set(5, 1);

        System.out.println(array.toString());
    }
}
