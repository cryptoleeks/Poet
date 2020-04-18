import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Yonggang Shi
 * @Date: 2020/02/08 00:16
 * @Description:
 */
public class HeapOOM {

    static class OOMObject{
    }

    public static void main(String[] args){
        List<OOMObject> list =new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
