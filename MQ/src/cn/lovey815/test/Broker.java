package cn.lovey815.test;

import java.util.SortedMap;
import java.util.concurrent.ArrayBlockingQueue;

import com.sun.tracing.dtrace.StabilityLevel;

import jdk.nashorn.internal.ir.IfNode;

public class Broker {
    //队列最大容量
    private final  static  int MAX_SIZE=3;

    //保存消息容器
    private static ArrayBlockingQueue messageQueue = new ArrayBlockingQueue(MAX_SIZE);

    //生产者
    public  static void produce(String msg){
        if (messageQueue.offer(msg)){
            System.out.println("成功想消息中心投递消息："+msg+",当前暂存的消息数量是："+messageQueue.size());

        }
        else{
            System.out.println("消息处理中心内暂存的消息到达最大负荷，不能继续存入消息！");
        }
        System.out.println("--------------------------------");
    }

    //消费者
    public static String consume(){
        String msg= (String) messageQueue.poll();
        if (msg != null){
                //消费条件满足，从消息容器中取出一条
            System.out.println("已经消费消息："+msg+",当前暂存的消息数量是："+messageQueue.size());
        }
        else {
            System.out.println("当前没有消息要消费！");
        }
        System.out.println("-----------------------------");
        return msg;
    }

}
