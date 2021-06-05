package com.mylg.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
@EnableAutoConfiguration
@EnableScheduling
public class Example {

    @RequestMapping("/")
    String home() throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            System.out.println("打印数据 ；i={}" + i);
            Thread.sleep(1 * 1000);
        }
        return "Hello World!";
    }

    @Scheduled(initialDelay = 1000, fixedDelay = 50000)
    public void sendResume() {
        for (int i = 0; i < 30; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("i=" + i + ";执行定时任务 ：" + LocalTime.now().toString());
        }
    }

    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler scheduler = new CustomTaskScheduler();
        scheduler.setPoolSize(10);
        return scheduler;
    }

    @Bean
    public ScheduleGracefulShutdown scheduleGracefulShutdown(ApplicationContext applicationContext) {
        return new ScheduleGracefulShutdown(applicationContext);
    }

    @Bean
    public TomcatGracefulShutdown gracefulShutdown() {
        return new TomcatGracefulShutdown();
    }

    @Bean
    public TomcatEmbeddedServletContainerFactory webServerFactory(final TomcatGracefulShutdown gracefulShutdown) {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        factory.addConnectorCustomizers(gracefulShutdown);
        return factory;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication application = new SpringApplication(Example.class);
        // 不适用默认的shutDownHook
        // application.setRegisterShutdownHook(false);
        ConfigurableApplicationContext context = application.run(args);
        // Runtime.getRuntime().addShutdownHook(new Thread(new GracefulShutdownHook(context)));
    }

}
