import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author jiangqiaonan
 * @date 2020-11-13
 */
public class ScheduleGracefulShutdown implements ApplicationListener<ContextClosedEvent> {
    private static final Logger log = LoggerFactory.getLogger(TomcatGracefulShutdown.class);

    public ScheduleGracefulShutdown(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    private final ApplicationContext applicationContext;

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        TaskScheduler scheduler = applicationContext.getBean(TaskScheduler.class);
        if (scheduler instanceof CustomTaskScheduler) {
            try {
                ((CustomTaskScheduler) scheduler).cancelTask();
                // log.warn("schedule thread pool did not shut down gracefully within 30 seconds. Proceeding with forceful shutdown");

                //最多等待30s
                while (!((CustomTaskScheduler) scheduler).getScheduledExecutor().awaitTermination(30, TimeUnit.SECONDS)) {
                    log.warn("schedule thread pool did not shut down gracefully within 30 seconds. Proceeding with forceful shutdown");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (scheduler instanceof ConcurrentTaskExecutor) {
            try {
                Executor executor = ((ConcurrentTaskExecutor) scheduler).getConcurrentExecutor();
                if (executor instanceof ExecutorService) {
                    //最多等待30s
                    while (!((ExecutorService) executor).awaitTermination(30, TimeUnit.SECONDS)) {
                        log.warn("schedule thread pool did not shut down gracefully within 30 seconds. Proceeding with forceful shutdown");
                    }
                }

            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
