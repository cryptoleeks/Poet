package cn.loveyx815.rocketmq.tx;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.loveyx815.rocketmq.consts.Consts;

/**
 * @Auther: Yonggang Shi
 * @Date: 2020/02/03 22:11
 * @Description:
 */
public class TransactionConsumer {

    private static   Logger logger = LoggerFactory.getLogger(TransactionConsumer.class);

    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer =new DefaultMQPushConsumer("transaction_consumer_group");
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.setNamesrvAddr(Consts.MQ_ADDR);
        consumer.subscribe("TopicTransaction","*");
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            private Random random = new Random();
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for (MessageExt msg: list) {
                    logger.info("消息消费者接收到消息"+msg);
                    logger.info("接收到的消息标签："+new String(msg.getTags()));
                    logger.info("接收到消息内容："+new String(msg.getBody()));
                }
                try {
                    //模拟业务处理
                    TimeUnit.SECONDS.sleep(random.nextInt(5));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return  ConsumeConcurrentlyStatus.RECONSUME_LATER;
                }

                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
    }
}
