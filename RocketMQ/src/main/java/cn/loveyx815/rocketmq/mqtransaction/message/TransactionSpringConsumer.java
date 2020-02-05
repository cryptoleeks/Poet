package cn.loveyx815.rocketmq.mqtransaction.message;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Auther: Yonggang Shi
 * @Date: 2020/02/04 18:41
 * @Description: 消费者
 */
public class TransactionSpringConsumer {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private String consumerGropuName;
    private String nameServerAddr;
    private String topicName;
    private DefaultMQPushConsumer consumer;
    private MessageListenerConcurrently messageListener;

    public TransactionSpringConsumer(String consumerGropuName,String nameServerAddr,String topicName,MessageListenerConcurrently messageListener){
        this.consumerGropuName=consumerGropuName;
        this.messageListener=messageListener;
        this.nameServerAddr=nameServerAddr;
        this.topicName=topicName;
    }

    public void init () throws  Exception{
        logger.info("开始启动消息消费者服务。。。");
        consumer=new DefaultMQPushConsumer(consumerGropuName);
        consumer.setNamesrvAddr(nameServerAddr);
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.subscribe(topicName,"*");
        consumer.registerMessageListener(messageListener);
        consumer.start();
        logger.info("消息消费者服务启动成功");
    }

    public void destory(){
        logger.info("开始关闭消息消费者服务。。");
        consumer.shutdown();
        logger.info("消费者服务已关闭");
    }

    public  DefaultMQPushConsumer getConsumer(){
        return  consumer;
    }
}
