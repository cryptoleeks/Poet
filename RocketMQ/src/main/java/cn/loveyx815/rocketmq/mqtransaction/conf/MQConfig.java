package cn.loveyx815.rocketmq.mqtransaction.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.sun.xml.internal.ws.transport.http.server.EndpointImpl;

import cn.loveyx815.rocketmq.consts.Consts;
import cn.loveyx815.rocketmq.mqtransaction.message.TransactionMessageListener;
import cn.loveyx815.rocketmq.mqtransaction.message.TransactionSpringConsumer;
import cn.loveyx815.rocketmq.mqtransaction.message.TransactionSpringProducer;
import cn.loveyx815.rocketmq.mqtransaction.message.UserLocalTransactionListener;

/**
 * @Auther: Yonggang Shi
 * @Date: 2020/02/04 23:11
 * @Description: RocketMQ相关bean注入
 */
@Configuration
@ComponentScan(value = "cn.loveyx815.rocketmq.mqtransaction.message")
public class MQConfig {

//    @Bean(name = "userLocalTransactionListener")
//    public UserLocalTransactionListener userLocalTransactionListener() {
//        return new UserLocalTransactionListener();
//    }
//
//    @Bean(name = "transactionMessageListener")
//    public TransactionMessageListener transactionMessageListener() {
//        return new TransactionMessageListener();
//    }
//    @Bean
//    public Endpoint endpointHttp(UserLocalTransactionListener userLocalTransactionListener) {
//        EndpointImpl endpoint = new EndpointImpl(springBus(), userLocalTransactionListener);
//        endpoint.publish("/messageWebService");
//        return endpoint;
//    }

    @Bean(name = "prooducer", initMethod = "init", destroyMethod = "destory")
    @DependsOn(value = "userLocalTransactionListener")
    public TransactionSpringProducer transactionSpringProducer(UserLocalTransactionListener userLocalTransactionListener) {
        return new TransactionSpringProducer("transaction_spring_producer_group", Consts.MQ_ADDR, 2, 5, 1000, userLocalTransactionListener);
    }

    @Bean(name = "consumer", initMethod = "init", destroyMethod = "destory")
    @DependsOn(value = "transactionMessageListener")
    public TransactionSpringConsumer transactionSpringConsumer( TransactionMessageListener transactionMessageListener) {
        return new TransactionSpringConsumer("transaction_consumer_group4", Consts.MQ_ADDR, "distributed_transaction_spring_topic", transactionMessageListener);
    }
}
