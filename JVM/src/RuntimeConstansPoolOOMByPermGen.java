import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Yonggang Shi
 * @Date: 2020/02/09 16:59
 * @Description:
 */
public class RuntimeConstansPoolOOMByPermGen {

    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        int  i =0 ;
        while (true){
            list.add(String.valueOf(i).intern());
        }
    }
}
