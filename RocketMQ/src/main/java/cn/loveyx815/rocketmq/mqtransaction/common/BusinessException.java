package cn.loveyx815.rocketmq.mqtransaction.common;

/**
 * @Auther: Yonggang Shi
 * @Date: 2020/02/04 17:07
 * @Description: 业务异常类
 */
public class BusinessException extends RuntimeException {

    public BusinessException(){
        super();
    }

    public BusinessException(String msg){
        super(msg);
    }

    public BusinessException(Throwable e){
        super(e);
    }

    public BusinessException(String msg,Throwable e){
        super(msg,e);
    }
}
