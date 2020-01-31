package cn.loveyx815.rocketmq.mq;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * @Auther: Yonggang Shi
 * @Date: 2020/1/29/029 16:26
 * @Description:
 */
public class Producer {

    public static void main(String[] args) throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException, MQBrokerException {
        //创建一个消息生产者，并设置一个消息生产组
        DefaultMQProducer producer =new DefaultMQProducer("shi_producer_group");
        //指定nameSERVER地址
        producer.setNamesrvAddr("114.55.254.102:9876");

        //初始化producer，在整个生命周期中只需要初始化一次
        producer.start();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入发生的消息");
        while (sc.hasNext()){
            //创建一个消息对象，指定其主题、标签、消息内容
            Message message = new Message(
                    "topic_example_java", //消息主题
                    "TagA",//消息标签
                    (sc.nextLine()).getBytes(RemotingHelper.DEFAULT_CHARSET)//消息内容
            );
            //发送消息并返回结果
            SendResult  sendResult = producer.send(message);
            System.out.printf("%s%n",sendResult);
        }

        //一旦生产者实例不再被使用，则将其关闭，包括清理资源、关闭网络连接等
        producer.shutdown();


    }

}
