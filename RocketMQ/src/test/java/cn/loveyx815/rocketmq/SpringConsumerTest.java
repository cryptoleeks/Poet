package cn.loveyx815.rocketmq;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cn.loveyx815.rocketmq.spring.SpringCousumer;

/**
 * @Auther: Yonggang Shi
 * @Date: 2020/01/31 14:45
 * @Description: 消费者单测
 */
@SpringBootTest
public class SpringConsumerTest {

    @Autowired
    private SpringCousumer cousumer;

    @Test
    public void  consume() throws  Exception {
        Thread.sleep(1000*200);

        cousumer.getConsumer().shutdown();

    }
}
