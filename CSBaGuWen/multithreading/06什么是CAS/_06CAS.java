import java.util.concurrent.atomic.AtomicInteger;

public class _06CAS {
    public static void main(String[] args) {
        AtomicInteger atomicInteger=new AtomicInteger();
        //getAndAddInt通过一个while循环，一直调用compareAndSwapInt()方法来实现原子性add
        /*
        问题：
        1.并发量大时，会有额外消耗CPU资源
        2.ABA问题(追加版本信息解决)
         */
        atomicInteger.getAndAdd(1);
    }

}
