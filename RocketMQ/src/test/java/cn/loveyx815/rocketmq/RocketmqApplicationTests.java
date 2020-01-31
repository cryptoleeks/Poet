package cn.loveyx815.rocketmq;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cn.loveyx815.rocketmq.spring.SpringProducer;

@SpringBootTest
class RocketmqApplicationTests {

    @Autowired
    private SpringProducer producer;


    @Test
    void contextLoads() {
    }

    @Test
    public void sendMessage() throws Exception{

    }

}
