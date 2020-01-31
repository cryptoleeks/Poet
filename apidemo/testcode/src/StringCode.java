import java.util.HashMap;
import java.util.Map;

public class StringCode {

    public static void main(String[] args){

        String str2=new String("I am str2");

        StringBuilder sb1=new StringBuilder("I am sb1");
        StringBuilder sb2=new StringBuilder();
        sb2.append("I am sb2");
        String str1="I am str1";
        changeString(sb1);
        System.out.println(sb1);


        Map map=new HashMap<>();
        map.put("key","key1");
        System.out.println(map.get("key"));
        System.out.println(map.get("newkey"));
    }

    public static void changeString(StringBuilder originStr){
        originStr.replace(0,originStr.length(),"str1 change");
    }
    public static void changeObject(Map map){
        map=new HashMap<>();
        map.put("newkey","newkey1");
    }
}
