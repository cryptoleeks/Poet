/**
 * @Auther: Yonggang Shi
 * @Date: 2020/02/08 17:25
 * @Description: String.intern()引用测试
 */
public class RuntimeConstantRoolOOM {

    public static void main(String[] args) {
        //sb对象生成的字符堆上开个内存存该串
        //String.intern()只会在常量池中记录首次出现的实例引用,若有直接拿原来的常量池引用
        String str1 = new StringBuilder("JA").append("VA").toString();
        System.out.println(str1.intern() == str1); //true
        String str22 = new StringBuilder("java").toString();
        String str2 = new StringBuilder("ja").append("va").toString();//jdk常量池中本来就有“java”字符串，所以str2.intern() 不等于 str2

        System.out.println(str2.intern() == str2); //false
        System.out.println(str22 == str2); //false
        System.out.println(str22 == str22.intern()); //false


        String str3 = "JA"+"VA";
        System.out.println(str3.intern() == str3); //true
        String str4 = "ja"+"va";
        System.out.println(str4.intern() == str4); //false

    }

}
