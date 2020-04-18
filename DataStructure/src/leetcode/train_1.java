package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Yonggang Shi
 * @Date: 2020/02/16 14:01
 * @Description: 从两个列表中找到共同的元素，且他们的索引下标最小
 */
public class train_1 {
    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> maplist =new HashMap<>();
        List<String> list = new ArrayList<>(Arrays.asList(list1)) ;
        List<String> result = new ArrayList<>();
        List<String> strings = Arrays.asList(list2);
        int length1=list1.length;
       // list.addAll(length1)
        list.addAll(strings);
       // int length1=list1.length;
        for (int i=0;i<length1;i++){
            String strIndex=list.get(i);//获取list1中的元素
            int lastIndexOf = list.lastIndexOf(strIndex);//在整个list中查找strIndex
            if (i!=lastIndexOf){//当查找的索引下表不为list1中的位置，就是list2中的索引
                maplist.put(strIndex,i+lastIndexOf);
            }else {
                continue;
            }
        }
        int min=-1;
        Collection<Integer> values = maplist.values();
        for ( int value:values){
            if (min==-1){
                min=value;
            }else if (min>value){
                min=value;
            }
        }
        for (Map.Entry<String,Integer> entry:maplist.entrySet()){
            if (entry.getValue()==min){
                result.add(entry.getKey());
            }
        }

        return (String[]) result.toArray();
    }

    public static void main(String[] args){
        String[] str1 ={"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] str2 ={"Shogun", "Tapioca Express", "Burger King", "KFC"};

        findRestaurant(str1,str2);
    }
}
