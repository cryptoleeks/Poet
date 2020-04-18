package stack;

import java.util.Stack;

/**
 * @Auther: Yonggang Shi
 * @Date: 2020/02/15 17:44
 * @Description:计算数据表达式（栈）
 */
public class train_2 {
// 3+5*(2-5)/3
    public static void main(String[] args){
        Stack opearExpress =new Stack();//操作符栈
        opearExpress.push('#');
        Stack opearData =new Stack();//操作数栈

        String expressString= "3-2/2";
        char[] chars = expressString.toCharArray();
        boolean state=false;//是否计算

        for (char c :chars){
           // Stack tempExpress= opearExpress.lastElement();
            int a;//前参数
            int b;//后参数
            char flag=0;
            if (c<'0'||c>'9'){
                flag = compareOpr(opearExpress.lastElement().toString().charAt(0),c);
            }else {
                opearData.push(c);
                if (state){

                        b=Integer.parseInt(opearData.pop().toString());
                        a=Integer.parseInt(opearData.pop().toString());
                        opearData.push(getResult(a,b,opearExpress.pop().toString().charAt(0)));

                }
                state=false;
            }
            if (flag=='>'){
                opearExpress.push(c);
                state=false;
            }
            else if(flag=='<') {
                opearExpress.push(c);
                state=true;
            }
//            if (state){
//                b=Integer.parseInt(opearData.pop().toString());
//                a=Integer.parseInt(opearData.pop().toString());
//                opearData.push(getResult(a,b,opearExpress.pop().toString().charAt(0)));
//            }
        }

    while (opearExpress.lastElement().toString().charAt(0)!='#'){
        int b=Integer.parseInt(opearData.pop().toString());
         int a=Integer.parseInt(opearData.pop().toString());
        opearData.push(getResult(a,b,opearExpress.pop().toString().charAt(0)));
    }

    }
    /*
     * @Description: 根据运算符计算
     * @Param: [a, b, sign]
     * @Return: java.lang.Object
     * @Author: Yonggang Shi
     * @Date: 2020/2/15/015 下午 9:15
     */
    private static Object getResult(int a, int b, char sign) {
        int result=-1;

        switch (sign){
            case '+': result=a+b;break;
            case '-': result=a-b;break;
            case '*': result=a*b;break;
            case '/': result=a/b;break;
            default:result=-1;break;
        }
        return result;
    }

    /*
     * @Description: 判断运算符的优先级，返回>表示arg1优先级低入栈，<优先级高运算
     * @Param: [arg1, arg2]
     * @Return: char
     * @Author: Yonggang Shi
     * @Date: 2020/2/15/015 下午 9:05
     */
    public static char compareOpr(char arg1,char arg2){
        char c= '#';
        if (arg1=='#'){
            c='>';
        }else if ((arg1=='+'||arg1=='-')&&(arg2=='*'||arg2=='/')){
            c='<';
        }else if((arg2=='+'||arg2=='-')&&(arg1=='*'||arg1=='/')){
            c='>';
        }
        return c;
    }
}
