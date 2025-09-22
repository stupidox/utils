package com.hm.utils;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class ScheduledTask {
    public static void main(String[] args) {
        // 在使用Robot来模拟键盘事件时，启动报错java.awt.AWTException: headless environment
        // SpringApplication.run(ScheduledTask.class);
        // java.awt.headless 模式
        // Headless模式是系统的一种配置模式。在系统可能缺少显示设备、键盘或鼠标这些外设的情况下可以使用该模式。
        SpringApplicationBuilder builder = new SpringApplicationBuilder(ScheduledTask.class);
        builder.headless(false).run(args);

    }

    // [秒] [分] [小时] [日] [月] [周] [年]
    @Scheduled(cron = "1 0 20 * * ?")
    public void execute() {
        for (int i = 0; i < 30; i++) {
            new SGSUtils().run();
        }
        System.exit(0);
    }
}
