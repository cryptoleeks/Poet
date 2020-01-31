package cn.lovey815.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class BrokerServer implements Runnable {

    public static int SERVER_PROT = 9999;

    private final Socket socket;

    public BrokerServer(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream())
            )
        {
            while (true){
                String str = in.readLine();
                if (str == null ){
                    continue;
                }
                System.out.println("接收到原始数据："+str);
                if (str.equals("CONSUME")){//CONSUME表示要消费一条消息
                    //从消息队列中消费一条消息
                    String message = Broker.consume();
                    out.println(message);
                    out.flush();
                }
                else{
                    //其他情况比爱是生产消息入消息队列
                    Broker.produce(str);
                }
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception{
        ServerSocket server;
        server = new ServerSocket(SERVER_PROT);
        while (true){
            BrokerServer brokerServer =new BrokerServer(server.accept());
            new Thread(brokerServer).start();
        }
    }
}
