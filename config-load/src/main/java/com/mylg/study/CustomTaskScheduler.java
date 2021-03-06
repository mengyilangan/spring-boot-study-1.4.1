package com.mylg.study;

import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.ScheduledMethodRunnable;

import java.util.Date;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

/**
 * @author jiangqiaonan
 * @date 2020-11-14
 */
public class CustomTaskScheduler extends ThreadPoolTaskScheduler {
    private final Map<Object, ScheduledFuture<?>> scheduledTasks = new IdentityHashMap<>();

    void cancelTask(Object identifier) {
        ScheduledFuture future = scheduledTasks.get(identifier);
        if (null != future) {
            System.out.println("future is not null");
            future.cancel(true);
        }
    }

    public void cancelTask() {
        for (Map.Entry<Object, ScheduledFuture<?>> entry : scheduledTasks.entrySet()) {
            if (null != entry.getValue()) {
                System.out.println("future is not null");
                entry.getValue().cancel(true);
            }
        }
    }

    /**
     * call parent method and store the result Future for cancel task,
     * you can expand other method of you used.
     *
     * @param task   the task need to be executed
     * @param period the time between two continues execute
     * @return the result of task
     */
    @Override
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable task, long period) {
        ScheduledFuture<?> future = super.scheduleAtFixedRate(task, period);

        ScheduledMethodRunnable runnable = (ScheduledMethodRunnable) task;
        // Scheduled annotation only can used for no arguments method so hashCode plus method name is unique.
        scheduledTasks.put(runnable.getTarget(), future);

        return future;
    }

    /**
     * call parent method and store the result Future for cancel task,
     * you can expand other method of you used.
     *
     * @param task      the task need to be executed
     * @param startTime the task first executed time
     * @param period    the time between two continues execute
     * @return the result of task
     */
    @Override
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable task, Date startTime, long period) {
        ScheduledFuture<?> future = super.scheduleAtFixedRate(task, startTime, period);

        ScheduledMethodRunnable runnable = (ScheduledMethodRunnable) task;
        // Scheduled annotation only can used for no arguments method so hashCode plus method name is unique.
        scheduledTasks.put(runnable.getTarget(), future);
        return future;
    }
}
