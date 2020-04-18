package stack;

import java.util.Stack;

/**
 * @Auther: Yonggang Shi
 * @Date: 2020/02/15 14:57
 * @Description: 十进制转换八进制（栈）
 */
public class train_1 {
    public static void main(String[] args){
        //stack init
        Stack<Integer> stack =new Stack<>();

        convertToOther(stack,1348);

    }

    public static void convertToOther(Stack<Integer> statk,int n){
        while (n>0){
            statk.push(n%8);
            n/=8;
        }
        while (!statk.empty()){
            System.out.println("【转换8进制为】"+statk.pop());
        }
    }
}
