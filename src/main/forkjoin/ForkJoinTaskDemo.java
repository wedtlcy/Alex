package forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * ForkJoin 求和
 * <p>
 * 从JDK1.7开始，Java提供Fork/Join框架用于并行执行任务，它的思想就是讲一个大任务分割成若干小任务，最终汇总每个小任务的结果得到这个大任务的结果。
 * 这种思想和MapReduce很像（input --> split --> map --> reduce --> output）
 * </p>
 * <href>https://www.cnblogs.com/cjsblog/p/9078341.html</href>
 *
 * @author chuanyin.li
 * @create 2019-01-24 10:19
 **/
public class ForkJoinTaskDemo {

    private final static int FORSIZE = 100;

    class SumTask extends RecursiveTask<Integer> {

        private final int THRESHOLD = 20;
        private int start;
        private int end;
        private int[] intArr;

        public SumTask(int start, int end, int[] intArr) {
            this.start = start;
            this.end = end;
            this.intArr = intArr;
        }

        /**
         * 小计
         * @return
         */
        private Integer subTotal() {
            Integer sum = 0;
            for (int i = start; i < end; i++) {
                sum += intArr[i];
            }
            System.out.println(Thread.currentThread().getName() + ": ∑(" + start + "~" + end + ")=" + sum);
            return sum;
        }


        /**
         * The main computation performed by this task.
         *
         * @return the result of the computation
         */
        @Override
        protected Integer compute() {
            if((end -start) <= THRESHOLD){
                return subTotal();
            }else{
                //求中位数
                int middle = (start + end) / 2;
                SumTask left = new SumTask(start,middle,intArr);
                SumTask right = new SumTask(middle,end,intArr);
                left.fork();
                right.fork();
                return left.join() + right.join();
            }
        }
    }

    public static void main(String[] args) throws Exception {

        int[] arr = new int[100];
        for (int i = 0; i < FORSIZE; i++) {
            arr[i] = i + 1;
        }

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> result = forkJoinPool.submit(new ForkJoinTaskDemo().new SumTask(0,arr.length,arr));
        System.out.println("最终的结果:"+result.invoke());
        forkJoinPool.shutdown();

    }
}
