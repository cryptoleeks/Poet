package gc;

/**
 * @Auther: Yonggang Shi
 * @Date: 2020/02/09 17:58
 * @Description: A B 对象中的属性互相引用是否gc
 */
public class ReferenceCountingGC {
    public Object instance = null;
    private  static final int _1MB=  1024*1024;

    private byte[] bigSize = new  byte[2*_1MB];

    public static void testGC(){
        ReferenceCountingGC objA= new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance=objB;
        objB.instance=objA;

        objA=null;
        objB=null;
        System.gc();
    }

}
