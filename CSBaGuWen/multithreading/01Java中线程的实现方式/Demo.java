import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class Demo {
    //所有方法，追其底层，只有一种方法，那就是实现Runable接口


    public static void main(String[] args) {
//        method1();
//        method2();
//
//        try {
//            method3();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

        method5();

        for (int i = 100; i < 200; i++) {
            System.out.println("main:" + i);
        }


    }

    public static void method1() {
        //第一种实现方式
        //1.继承Thread类 重写run方法
        Method1 method1 = new Method1();
        //如果直接调用run方法，会让当前线程执行run方法中的逻辑
        //也就不是并发，而是依次执行了
        //jb1.run();
        method1.start();
    }

    public static void method2() {
        //第二种实现方式
        //2.实现Runnable接口 重写run方法
        Thread thread2 = new Thread(new Method2());
        thread2.start();
    }

    public static void method3() throws Exception {
        //第三种实现方式
        //3.实现Callable重写call方法，配合FutureTask
        //Callable一般用于 有返回结构的 非阻塞的 执行方法

        //1.创建Callable
        MyCallable3 method3 = new MyCallable3();
        //2.创建FutureTask，传入Callable
        FutureTask futureTask = new FutureTask(method3);
        Thread thread3 = new Thread(futureTask);
        thread3.start();
    }

    public static void method4() {
        //第四种实现方式
        //4.基于线程池构建线程
        //ThreadPoolExecutor里的 Worker类实现了 Runnable接口
    }

    public static void method5() {
        //第五种实现方式
        //lambda表达式，重写Thread的run方法(根本上和方法一相同）
        Thread thread5 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Method5:" + i);
            }
        });
        thread5.start();
    }


}

class Method1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Method1:" + i);
        }
    }
}

class Method2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Method2:" + i);
        }
    }
}

class MyCallable3 implements Callable {
    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println("Method3:" + i);
        }
        return null;
    }
}


