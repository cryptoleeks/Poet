import javax.print.attribute.standard.DocumentName;

/**
 * @Auther: Yonggang Shi
 * @Date: 2020/02/08 15:58
 * @Description: 通过多线程实现栈扩充导致的OOM
 */
public class JavaVMStackOOM {
    private void dontStop(){
        while (true){

        }
    }
     public  void stackLeakByThread(){
         while (true){
             Thread thread =new Thread(new Runnable() {
                 @Override
                 public void run() {
                     dontStop();
                 }
             });
             thread.start();
         }
     }

     public static void main(String[] args){
         JavaVMStackOOM javaVMStackOOM =new JavaVMStackOOM();
         javaVMStackOOM.stackLeakByThread();
     }
}
