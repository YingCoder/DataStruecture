import org.junit.Test;

/**
 * @Author: weizujie
 * @Date: 2020/5/13
 * @Version: 1.0
 * @Github: https://github.com/weizujie
 */
public class QueueTest {
    @Test
    public void LoopQueueTest() {

        LoopQueue queue = new LoopQueue();

        for (int i = 0; i < 5; i++) {
            queue.enQueue(i);
        }

        queue.deQueue();
    }
}
