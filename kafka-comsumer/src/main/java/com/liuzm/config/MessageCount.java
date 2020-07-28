package com.liuzm.config;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

public class MessageCount {

//    public static AtomicInteger count = new AtomicInteger(0);

    private static final Logger logger = LoggerFactory.getLogger(MessageCount.class);

    @KafkaListener(topics = {"test8", "test9", "test10", "test11"}, containerFactory = "kafkaListenerContainerFactory")
    public void consumer0(List<ConsumerRecord<?, ?>> records) {

        for (ConsumerRecord<?, ?> record : records) {
            //自增加1
            //count.getAndIncrement();
            //do something
            System.out.println("接收消息成功");
            System.out.println("业务代码");
            logger.info("topic is {}, offset is {}, value is {}", record.topic(), record.offset(), record.value());
        }

    }


    //定时任务每天8点到18点每1分钟统计一次TPS（流量）
    @Scheduled(cron = "1 * * * * ?")
    public void TPSCount() {
//        int topicNum = count.get();
//        //重置count=0
//        count.getAndSet(0);
//        int tps = topicNum / 4;
//        System.out.println("topic的个数 = " + topicNum + "; 120秒内的tps = " + tps + "; 时间为 = " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        System.out.println("=====================");
    }
}
