/**
 * @Author: weizujie
 * @Date: 2020/5/13
 * @Version: 1.0
 * @Github: https://github.com/weizujie
 */
public class QueueTest {
    public static void main(String[] args) {
        LoopQueue<Integer> loopQueue = new LoopQueue<Integer>();

        for (int i = 0; i < 5; i++) {
            loopQueue.enqueue(i);
        }

        System.out.println(loopQueue.toString());
    }

}
