import org.junit.Test;

/**
 * @Author: weizujie
 * @Date: 2020/5/18
 * @Version: 1.0
 * @Github: https://github.com/weizujie
 */
public class DoubleLinkedListTest {


    @Test
    public void doubleLinkedListTest() {
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<Integer>();

        // add
        doubleLinkedList.add(0, 0);
        doubleLinkedList.add(1, 1);
        doubleLinkedList.add(2, 2);
        doubleLinkedList.add(3, 3);
        doubleLinkedList.add(4, 4);
        doubleLinkedList.add(5, 5);
        System.out.println(doubleLinkedList.toString());


        doubleLinkedList.add(3, 123);
        System.out.println(doubleLinkedList.toString());

        doubleLinkedList.add(2, 123);
        System.out.println(doubleLinkedList.toString());

        System.out.println("-------------------");

        // del
        doubleLinkedList.removeFirst();
        System.out.println(doubleLinkedList.toString());

        doubleLinkedList.removeLast();
        System.out.println(doubleLinkedList.toString());
    }
}
