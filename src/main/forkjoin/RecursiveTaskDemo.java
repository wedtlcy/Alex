package forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * <p>Java Fork Join框架无返回值之有返回值</p>
 *
 * <p>斐波那契数列数列从第3项开始,每一项都等于前两项之和</p>
 *
 * <p>
 * 从JDK1.7开始，Java提供Fork/Join框架用于并行执行任务，它的思想就是讲一个大任务分割成若干小任务，最终汇总每个小任务的结果得到这个大任务的结果。
 * 这种思想和MapReduce很像（input --> split --> map --> reduce --> output）
 * </p>
 * <href>https://www.cnblogs.com/cjsblog/p/9078341.html</href>
 *
 * @author chuanyin.li
 * @create 2019-01-24 10:19
 **/
public class RecursiveTaskDemo {

    private static class Fibonacci extends RecursiveTask<Integer> {

        final int n;

        public Fibonacci(int n) {
            this.n = n;
        }


        /**
         * The main computation performed by this task.
         *
         * @return the result of the computation
         */
        @Override
        protected Integer compute() {
            if (n <= 1) {
                return n;
            }else{
                Fibonacci fibonacci1 = new Fibonacci(n-1);
                fibonacci1.fork();
                Fibonacci fibonacci2 = new Fibonacci(n-1);
                return fibonacci2.compute() + fibonacci1.join();
            }
        }
    }

    public static void main(String[] args) throws Exception {

        ForkJoinPool frokJoinPool = new ForkJoinPool();
        Future<Integer> future = frokJoinPool.submit(new Fibonacci(5));
        System.out.println(future.get());
        frokJoinPool.shutdown();

    }

}
