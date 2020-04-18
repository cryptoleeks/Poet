package classLoad;

/**
 * @Auther: Yonggang Shi
 * @Date: 2020/04/04 22:23
 * @Description:
 */
public class Main {
    public static void main(String[] args){
        //通过子类去使用父类的静态字段（非final修饰），不会先初始化子类再去初始化父类
//        System.out.println(SubClass.value);

        SubClass[] array = new SubClass[10];
    }
}
