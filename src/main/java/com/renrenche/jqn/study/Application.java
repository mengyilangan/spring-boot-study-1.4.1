package com.renrenche.jqn.study;

//import com.renrenche.messagebus.client.annotation.EnableMessageBusClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jooq.JooqAutoConfiguration;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;

/**
 * @author jiangqiaonan
 */
//@EnableScheduling
//@EnableMessageBusClient("com.renrenche.jqn.study.messagebus.consumer")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, SessionAutoConfiguration.class, JooqAutoConfiguration.class})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Scheduled(fixedDelay = 100 * 1000)
//    public void job() {
//        for (int i = 0; i < 50; i++) {
//            try {
//                System.out.println("i=" + i + ";hello world");
//                Thread.sleep(1);
//            } catch (Exception e) {
//
//            }
//        }
//    }
//
//    @Bean
//    public TaskExecutor taskExecutor() {
//        ThreadPoolTaskScheduler taskExecutor = new ThreadPoolTaskScheduler();
//        taskExecutor.setPoolSize(1);
//        taskExecutor.setThreadNamePrefix("schedule-");
//        taskExecutor.setRemoveOnCancelPolicy(true);
//        taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
//        return taskExecutor;
//    }
}
