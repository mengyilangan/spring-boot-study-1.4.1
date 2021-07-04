/**
 * @author mylg
 * @date 2021-07-03
 */
package com.mylg.study.kafka.producer;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Producer {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties properties = new Properties();
        //以下三个是必须要配置的参数：
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "81.70.142.253:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("acks", "all");
        properties.put("client.id", "sampleProducer");
        properties.put("retries", 1);
        properties.put("batch.size", 20000);
        properties.put("linger.ms", 1);
        properties.put("delivery.timeout.ms", 1000 * 120);
        //buffer.memory ：这 产者 以用来缓冲等待被发送到 Kafka 服务器的消息的存大小。
        // 简单来说，是 Java 生产者可以收集未发送消息的总内存。当达到这个限制时，生产者会在抛出异常之前将消息阻塞 max.block.ms 毫秒。
        // 如果你的批处理数据量更多，则需要为生产者缓冲区分配更多的内存。
        properties.put("buffer.memory", 24568545);
        //此外，为了避免记录无限期排队，你可以使用 request.timeout.ms 设置一个超时时间
        //果这个超时时间在成功发送消息之前到期，那么它将记录从队列中删除，并抛出一个异常。
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
        for (int i = 0; i < 1; i++) {
            String message = "Hello this is record " + i;
            ProducerRecord<String, String> data = new ProducerRecord<>("test1", message);
            Future<RecordMetadata> future = producer.send(data);
        }
        producer.close();
        //异步

        //同步获取
        //RecordMetadata recordMetadataFuture = producer.send(producerRecord).get();

        //回调
        //producer.send(producerRecord, new ProducerCallBack());
    }

    private static void print(String value, RecordMetadata metadata) {
        System.out.println("data:" + value + ";metadata=" + metadata.toString());
    }

    private static class ProducerCallBack implements Callback {

        @Override
        public void onCompletion(RecordMetadata recordMetadata, Exception e) {
            if (e != null) {
                System.out.println("Error while producing message to topic :" + recordMetadata);
                e.printStackTrace();
            } else {
                String message = String.format("sent message to topic:%s partition:%s  offset:%s", recordMetadata.topic(), recordMetadata.partition(), recordMetadata.offset());
                System.out.println(message);
            }
        }
    }
}
