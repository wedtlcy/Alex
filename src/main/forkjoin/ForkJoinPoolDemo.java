package forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * ForkJoin 批量发送消息
 * <p>
 *      从JDK1.7开始，Java提供Fork/Join框架用于并行执行任务，它的思想就是讲一个大任务分割成若干小任务，最终汇总每个小任务的结果得到这个大任务的结果。
 *      这种思想和MapReduce很像（input --> split --> map --> reduce --> output）
 * </p>
 * <href>https://www.cnblogs.com/cjsblog/p/9078341.html</href>
 *
 * @author chuanyin.li
 * @create 2019-01-24 10:19
 **/
public class ForkJoinPoolDemo {

    private final static int FORSIZE  = 123;

    class BatchSendMsg extends RecursiveAction {

        private final int THRESHOLD = 10;
        private int start;
        private int end;
        private List<String> list;

        public BatchSendMsg(int start, int end, List<String> list) {
            this.start = start;
            this.end = end;
            this.list = list;
        }

        /**
         * The main computation performed by this task.
         */
        @Override
        protected void compute() {

            if ((end - start) <= THRESHOLD) {
                for (int i = start; i < end; i++) {
                    System.out.println(Thread.currentThread().getName() + ": " + list.get(i));
                }
            } else {
                int mid = (start + end) / 2;
                invokeAll(new BatchSendMsg(start, mid, list), new BatchSendMsg(mid, end, list));
            }
        }
    }

    public static void main(String[] args) throws  Exception{
        List<String> list = new ArrayList<>(130);
        for (int i = 0; i < FORSIZE; i++) {
            list.add(String.valueOf(i));
        }

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.submit(new ForkJoinPoolDemo().new BatchSendMsg(0, list.size(), list));
        forkJoinPool.awaitTermination(10, TimeUnit.SECONDS);
        forkJoinPool.shutdown();
    }
}
