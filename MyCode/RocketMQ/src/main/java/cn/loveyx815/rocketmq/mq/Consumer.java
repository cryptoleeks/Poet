package cn.loveyx815.rocketmq.mq;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;

import org.apache.rocketmq.common.message.MessageExt;

/**
 * @Auther: Yonggang Shi
 * @Date: 2020/1/29/029 16:26
 * @Description:
 */
public class Consumer {

    public static void main(String[] args) throws Exception{
        //创建一个消费者，帮你改设置一个消费者组
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("shi_consumer_group");
        //指定nameserver 地址
        consumer.setNamesrvAddr("114.55.254.102:9876");
        //设置consumer第一次启动时从队列首或尾开始消费
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        //订阅指定Topic下的所有消息
        consumer.subscribe("topic_example_java","*");
        //注册消息监听器
        consumer.registerMessageListener(
                new MessageListenerConcurrently(){

                    @Override
                    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                        //默认list里只有一条消息，可以通过设置参数来批量接受消息
                        if (list != null){
                            for (MessageExt ext:list){
                                try {
                                    System.out.println("【"+new Date()+"】"+new String(ext.getBody(),"UTF-8"));
                                }catch (UnsupportedEncodingException e){
                                    e.printStackTrace();
                                }
                            }
                        }
                        else {
                            System.out.println("么有监听到消息。。。");
                        }
                        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;

                    }
                }
        );
        //消费者对象在使用之前必须要调用start方法初始化
        consumer.start();
        System.out.println(" Consumer started...");
    }
}
