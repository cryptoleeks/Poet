package cn.loveyx815.rocketmq.mqtransaction.message;

import javax.annotation.Resource;

import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import cn.loveyx815.rocketmq.mqtransaction.bean.UserPointMessage;
import cn.loveyx815.rocketmq.mqtransaction.service.UserService;

/**
 * @Auther: Yonggang Shi
 * @Date: 2020/02/04 18:25
 * @Description: 本地事务监听器，用作生产者生产消息的逻辑
 */
@Component
public class UserLocalTransactionListener implements TransactionListener {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;
    @Override
    public LocalTransactionState executeLocalTransaction(Message message, Object o) {
        //本地事务处理逻辑
        logger.info("本地事务执行。。。");
        logger.info("消息标签："+new String(message.getTags()));
        logger.info("消息内容："+new String(message.getBody()));
        //从消息体重获取积分消息对象
        UserPointMessage userPointMessage = JSON.parseObject(message.getBody(), UserPointMessage.class);
        //保存用户记录并提交本地事务
        userService.saveUser(userPointMessage.getUserId(),userPointMessage.getUserName());
        return LocalTransactionState.COMMIT_MESSAGE;
    }

    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
        //消息回查接口
        logger.info("服务器调用消息回查接口");
        logger.info("消息标签："+new String(messageExt.getTags()));
        logger.info("消息内容："+new String(messageExt.getBody()));
        //从消息体重获取积分消息对象
        UserPointMessage userPointMessage = JSON.parseObject(messageExt.getBody(),UserPointMessage.class);
        if (userPointMessage!= null){
            String userId = userPointMessage.getUserId();
            if (userService.getById(userId) != null){
                logger.info("本地插入用户表成功！");
//                表示本地事务执行成功
                return LocalTransactionState.COMMIT_MESSAGE;
            }
        }
        return LocalTransactionState.ROLLBACK_MESSAGE;
    }
}
