package cn.loveyx815.rocketmq.spring;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Auther: Yonggang Shi
 * @Date: 2020/01/30 17:11
 * @Description: 消息监听逻辑
 */
public class MessageListener implements MessageListenerConcurrently {

    private Logger logger =LoggerFactory.getLogger(this.getClass());
    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {

        if (list!=null){
            for (MessageExt ext : list){
                try {
                    logger.info("监听到消息："+new String(ext.getBody(),"UTF-8"));
                }catch (UnsupportedEncodingException e){
                    logger.info("解码异常"+e);
                }
            }
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}
