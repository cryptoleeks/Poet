package cn.loveyx815.rocketmq;

import java.io.IOException;

import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cn.loveyx815.rocketmq.spring.SpringProducer;
import sun.plugin2.message.Serializer;

/**
 * @Auther: Yonggang Shi
 * @Date: 2020/01/31 14:44
 * @Description: 生产者单测
 */
@SpringBootTest
public class SpringProducerTest {

    @Autowired
    private SpringProducer producer;

    @Test
    public void sendMessage() throws Exception{

        for (int i =0;i<20;i++){
            Message message = new Message(
                    "spring-rocketMQ-topic",
                    null,
                    ("spring-RocketMQ-demo"+i).getBytes(RemotingHelper.DEFAULT_CHARSET)
            );
            SendResult sendResult = producer.getProducer().send(message);

            System.out.printf("%s%n",sendResult);
            }

    }


}
