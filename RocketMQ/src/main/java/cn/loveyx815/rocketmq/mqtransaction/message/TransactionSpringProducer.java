package cn.loveyx815.rocketmq.mqtransaction.message;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Auther: Yonggang Shi
 * @Date: 2020/02/04 17:55
 * @Description: 消息生产者
 */
public class TransactionSpringProducer {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private String producerGroupName;
    private String nameServerAdd;
    private int corePoolSize = 1;
    private int maximumPoolSize = 5;
    private long keepAliveTime = 100;
    private TransactionMQProducer producer;
    private TransactionListener transactionListener;
    public TransactionSpringProducer(String producerGroupName,String nameServerAdd,int corePoolSize,int maximumPoolSize,long keepAliveTime,TransactionListener transactionListener){
        this.corePoolSize=corePoolSize;
        this.keepAliveTime=keepAliveTime;
        this.maximumPoolSize=maximumPoolSize;
        this.nameServerAdd=nameServerAdd;
        this.producerGroupName=producerGroupName;
        this.transactionListener=transactionListener;
    }

    public  void init() throws Exception{
        logger.info("开始启动消息生产者服务。。。");

        producer = new TransactionMQProducer(producerGroupName);
        producer.setNamesrvAddr(nameServerAdd);
        ExecutorService executorService = new ThreadPoolExecutor(corePoolSize,maximumPoolSize,keepAliveTime, TimeUnit.SECONDS,new ArrayBlockingQueue<>(2000),(Runnable r )->{
            Thread thread = new Thread(r);
            thread.setName("client-transaction-msg-check-thread");
            return thread;
        });
        producer.setExecutorService(executorService);
        producer.setTransactionListener(transactionListener);
        producer.start();
        logger.info("消息生产者已启动！！！");
    }

    public void destory(){
        logger.info("开始关闭消息生产服务。。");
        producer.shutdown();
        logger.info("生产者服务已关闭");
    }
    public DefaultMQProducer getProducer(){
        return producer;
    }


}
