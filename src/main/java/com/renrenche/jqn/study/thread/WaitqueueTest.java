package com.renrenche.jqn.study.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author jiangqiaonan
 * @date 2020/11/14
 */
public class WaitqueueTest {
    public static void main(String[] args) {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();
        for (int i = 1; i <= 100; i++) {
            workQueue.add(new Task(String.valueOf(i)));
        }
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, workQueue);
        executor.execute(new Task("0"));
        executor.shutdownNow();
        System.out.println("workQueue size = " + workQueue.size() + " after shutdown");
    }

    static class Task implements Runnable {
        String name;

        public Task(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 1000; i++) {
                System.out.println("task " + name + " is running");
            }
            System.out.println("task " + name + " is over");
        }
    }
}
