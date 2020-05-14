/**
 * @Author: weizujie
 * @Date: 2020/5/13
 * @Version: 1.0
 * @Github: https://github.com/weizujie
 */
public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList.toString());
        }
        linkedList.removeFirst();
        System.out.println(linkedList.toString());

        linkedList.removeLast();
        System.out.println(linkedList.toString());

        linkedList.remove(1);
        System.out.println(linkedList.toString());
    }

}
