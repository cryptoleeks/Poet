package cn.loveyx815.rocketmq.mqtransaction.service;

import javax.annotation.Resource;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

import cn.loveyx815.rocketmq.mqtransaction.bean.User;
import cn.loveyx815.rocketmq.mqtransaction.bean.UserPointMessage;
import cn.loveyx815.rocketmq.mqtransaction.dao.UserDao;
import cn.loveyx815.rocketmq.mqtransaction.message.TransactionSpringProducer;

/**
 * @Auther: Yonggang Shi
 * @Date: 2020/02/04 21:21
 * @Description:用户业务逻辑
 */
@Service
public class UserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TransactionSpringProducer producer;

    @Autowired
    private UserDao userDao;

    @Transactional(rollbackFor = Exception.class)
    public void newUserAndPoint(String userName,Integer amount) throws Exception{
        //获取用户ID
        String userId = userDao.getId();

        //发送新增积分消息
        UserPointMessage message = new UserPointMessage();
        message.setUserId(userId);
        message.setUserName(userName);
        message.setAmount(amount);

        this.sendMessage(message);
    }
    /*
     * @Description: 给消费者发送消息
     * @Param: [message]
     * @Return: void
     * @Author: Yonggang Shi
     * @Date: 2020/2/4/004 下午 9:28
     */
    private void sendMessage(UserPointMessage pointMessage) throws MQClientException {
        Message message = new Message();
        message.setTopic("distributed_transaction_spring_topic");
        message.setTags("newUserAndPoint");
        message.setKeys(pointMessage.getUserId());
        //将积分对象转换成JSON字符串保存到时间的内容字段中
        message.setBody(JSON.toJSONString(pointMessage).getBytes());

        //发送消费 并封装本地事务逻辑
        SendResult sendResult = producer.getProducer().sendMessageInTransaction(message,"");
        logger.info("消息发送结果："+sendResult);
    }

    /*
     * @Description: 保存用户记录
     * @Param: [userId, userName]
     * @Return: void
     * @Author: Yonggang Shi
     * @Date: 2020/2/4/004 下午 9:34
     */
    public void saveUser(String userId, String userName) {
        userDao.insert(userId,userName);
    }

    public User getById(String userId) {
        return  userDao.getById(userId);
    }
}
