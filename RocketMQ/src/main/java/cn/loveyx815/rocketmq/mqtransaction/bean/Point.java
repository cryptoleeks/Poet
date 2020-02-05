package cn.loveyx815.rocketmq.mqtransaction.bean;

import lombok.Data;

/**
 * @Auther: Yonggang Shi
 * @Date: 2020/02/04 17:04
 * @Description: 用户积分
 */
@Data
public class Point {

    private String id;//主键
    private String userId;//用户ID
    private Integer amount;//积分金额
}
