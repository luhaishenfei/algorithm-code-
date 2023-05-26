public class ThreadStateDemo {
    public static void main(String[] args) throws InterruptedException {
        //操作系统层面有5种线程状态：
        /*
        新建状态(NEW)--start-->就绪状态(READY)--CPU调度-->运行状态(RUNNING)-->结束状态(TERMINATED)
                                                                 |
                                                                 --没有拿到锁资源-->等待状态(WAITING)
         */

        //JAVA里有6种线程状态，如下，详见Thread类的State枚举

        //NEW
        Thread thread1 = new Thread(() -> {
        });
        System.out.println(thread1.getState());

        //RUNNABLE
        Thread thread2 = new Thread(() -> {
            while (true) ;
        });
        thread2.start();
        thread2.sleep(500);
        System.out.println(thread2.getState());

        //BLOCKED
        Object obj = new Object();
        Thread thread3 = new Thread(() -> {
            //t3线程拿不到锁资源，导致变为BLOCKED状态
            synchronized (obj) {

            }
        });
        //main线程拿到obj的锁资源
        synchronized (obj) {
            thread3.start();
            thread3.sleep(500);
            System.out.println(thread3.getState());
        }

        //WAITING
        Object obj2=new Object();
        Thread thread4=new Thread(()->{
            synchronized (obj2){
                try {
                    obj2.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        thread4.start();
        Thread.sleep(500);
        System.out.println(thread4.getState());

        //TIMED_WAITING
        Thread thread5=new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread5.start();
        Thread.sleep(500);
        System.out.println(thread5.getState());

        //TERMINATED
        Thread thread6=new Thread(()->{
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread6.start();
        Thread.sleep(1000);
        System.out.println(thread6.getState());


    }

}
