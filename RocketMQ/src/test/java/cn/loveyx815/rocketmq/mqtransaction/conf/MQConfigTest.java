package cn.loveyx815.rocketmq.mqtransaction.conf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.loveyx815.rocketmq.RocketmqApplication;
import cn.loveyx815.rocketmq.mqtransaction.service.PointService;
import cn.loveyx815.rocketmq.mqtransaction.service.UserService;


/**
 * @Auther: Yonggang Shi
 * @Date: 2020/02/04 23:24
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RocketmqApplication.class})
public class MQConfigTest {
    @Autowired
    private UserService userService;



    @Test
    public void newUser() throws Exception{
        userService.newUserAndPoint("分布式事务测试new",100);
        Thread.sleep(5000);
    }
}