package cn.loveyx815.rocketmq.mqtransaction.bean;

import lombok.Data;

/**
 * @Auther: Yonggang Shi
 * @Date: 2020/02/04 17:06
 * @Description:消息类，用于发送消息是传递业务对象数据
 */
@Data
public class UserPointMessage {

    private String userId;
    private String userName;
    private Integer amount;

}
