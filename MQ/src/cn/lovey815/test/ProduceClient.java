package cn.lovey815.test;

import java.util.Scanner;

public class ProduceClient {

    public static void main(String[] args) throws Exception{
        MqClient client= new MqClient();
        //client.produce("Hello world!");
        Scanner sc =new Scanner(System.in);
        System.out.println("输入消费信息： ");
        while (sc.hasNext()){//输入包含CONSUME字符串表示消费信息
            String message = sc.nextLine();
            if (message.contains("CONSUME")){
                client.consume();
            }
            else
            {
                client.produce(message);
            }
        }

    }
}



