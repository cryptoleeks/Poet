package cn.loveyx815.rocketmq.mqtransaction.message;

import java.util.List;

import javax.annotation.Resource;

import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import cn.loveyx815.rocketmq.mqtransaction.bean.Point;
import cn.loveyx815.rocketmq.mqtransaction.bean.UserPointMessage;
import cn.loveyx815.rocketmq.mqtransaction.service.PointService;

/**
 * @Auther: Yonggang Shi
 * @Date: 2020/02/04 18:50
 * @Description: 事务消息监听器，用作消费者消费的监听逻辑实现
 */
@Component
public class TransactionMessageListener implements MessageListenerConcurrently {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private PointService pointService;
    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        try {
            for (MessageExt message:list){
                logger.info("消息消费者接收到消息:"+message);
                logger.info("接收到消息内容:"+new String (message.getBody()));
                //从消息体中获取积分消息对象
                UserPointMessage userPointMessage= JSON.parseObject(message.getBody(),UserPointMessage.class);
                if (userPointMessage!=null){
                    Point point = new Point();
                    point.setUserId(userPointMessage.getUserId());
                    point.setAmount(userPointMessage.getAmount());
                    //保存用户积分记录并提交本地事务
                    pointService.savePoint(point);
                }
            }
        }catch (Exception e){
            logger.error("消息消费出错"+e);
            return  ConsumeConcurrentlyStatus.RECONSUME_LATER;
        }
        //正常消费成功
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}
