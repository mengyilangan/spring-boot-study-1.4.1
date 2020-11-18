package com.renrenche.jqn.study.thread;

import java.util.concurrent.*;

/**
 * @author jiangqiaonan
 * @date 2020/11/14
 */
public class TestPool {
    public static void main(String[] args) {
        testShutDown();
    }

    /**
     * 固定线程数
     */
    public static void testFixedThreadPool() {
        while (true) {
            ExecutorService executorService = Executors.newFixedThreadPool(8);
            executorService.execute(() -> System.out.println("running"));
            executorService = null;
        }
    }

    /**
     * cached 核心线程数为0
     */
    public static void testCachedThreadPool() {
        while (true) {
            ExecutorService executorService = Executors.newCachedThreadPool();
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
            // 为了更好的模拟，动态修改为1纳秒
            threadPoolExecutor.setKeepAliveTime(1, TimeUnit.NANOSECONDS);
            threadPoolExecutor.execute(() -> System.out.println("running"));
        }
    }

    public static void testShutDown() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 4, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

        RejectedExecutionHandler handler = new RejectedExecutionHandler() {
            /**
             * r 代表提交的该任务,
             * executor:应该就是指的该线程池
             * @param r
             * @param executor
             */
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println("线程已经关闭，直接拒绝");
            }
        };
        executor.setRejectedExecutionHandler(handler);
        executor.execute(() -> System.out.println("before shutdown"));
        executor.shutdown();
        executor.execute(() -> System.out.println("after shutdown"));
    }
}
