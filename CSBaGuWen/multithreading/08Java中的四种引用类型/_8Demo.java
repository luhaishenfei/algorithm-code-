import java.lang.ref.SoftReference;

public class _8Demo {
    public static void main(String[] args) {
        //引用类型共有四种：强、软、弱、虚 (引用)

        //1. obj就是个强引用对象
        Object obj =new Object();

        //2。 软引用，借助SoftReference生成
//        SoftReference

        //3. 弱引用 如ThreadLocal类

        //4.虚引用，又称幽灵引用，回收垃圾时，配合队列来使用
    }
}
