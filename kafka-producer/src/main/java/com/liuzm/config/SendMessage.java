package com.liuzm.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SendMessage {
    @Autowired
    KafkaTemplate template;


    @Scheduled(cron = "*/1 * * * * ?")
    @Async
    public void sendMessge1() {
        for (int i = 0; i < 10; i++) {
            template.send("CUPS", "第" + i + "CUPS,请注意接收");
        }

        System.out.println("发送messageTestCUPS消息成功！");
    }

    @Scheduled(cron = "*/1 * * * * ?")
    @Async
    public void sendMessge2() {
        for (int i = 0; i < 20; i++) {
            template.send("ACP", "第" + i + "ACP,请注意接收");
        }

        System.out.println("发送messageTestACP消息成功！");
    }

    @Scheduled(cron = "*/1 * * * * ?")
    @Async
    public void sendMessge3() {
        for (int i = 0; i < 30; i++) {
            template.send("QRC", "第" + i + "条QRC,请注意接收");
        }

        System.out.println("发送messageTestQRC消息成功！");
    }




}
