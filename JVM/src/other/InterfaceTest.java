package other;

/**
 * @Auther: Yonggang Shi
 * @Date: 2020/04/17 15:55
 * @Description:
 */
public interface InterfaceTest {
    int a=0;
    void returnVoid();
    default int function1(){
        return a;
    }
}
