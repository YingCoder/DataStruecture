import org.junit.Test;

/**
 * @Author: weizujie
 * @Date: 2020/5/13
 * @Version: 1.0
 * @Github: https://github.com/weizujie
 */
public class SingleLinkedListTest {


    @Test
    public void singleLinkedListTest() {

        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();

        // add
        singleLinkedList.add(0, 0);
        singleLinkedList.add(1, 1);
        singleLinkedList.add(2, 2);
        singleLinkedList.add(3, 3);
        singleLinkedList.add(4, 4);
        singleLinkedList.add(5, 5);
        System.out.println(singleLinkedList.toString());


        singleLinkedList.addFirst(321);
        System.out.println(singleLinkedList.toString());

        singleLinkedList.addLast(123);
        System.out.println(singleLinkedList.toString());

        // remove
        singleLinkedList.remove(0);
        System.out.println(singleLinkedList.toString());

        singleLinkedList.removeFirst();
        System.out.println(singleLinkedList.toString());

        singleLinkedList.removeLast();
        System.out.println(singleLinkedList.toString());

        // setVal
        singleLinkedList.setVal(0, 123);
        System.out.println(singleLinkedList.toString());



    }
}
