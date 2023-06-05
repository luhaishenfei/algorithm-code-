public class EndThreadMethod {
    //3种方式 stop,共享变量,interrupt


    //2.使用共享变量 flat
    static volatile boolean flat=true;
    public static void main(String[] args) throws InterruptedException {
        //1.stop方法(不用)
        Thread t1=new Thread();
        t1.stop();


        //2.使用共享变量 flat
        Thread t2=new Thread(()->{
           while (flat){
               //处理任务
               System.out.println("t2 is working...");
           }
        });
        t2.start();
        Thread.sleep(500);
        //控制共享变量使线程停止
        flat=false;


        //3.interrupt
        //线程默认状态下，interrupt标记位是false
        System.out.println(Thread.currentThread().isInterrupted());
        //执行interrupt之后，再次查看打断信息
        Thread.currentThread().interrupt();
        //此时interrupt标记位是true
        System.out.println(Thread.currentThread().isInterrupted());
        //将interrupt标记位归位为false
        System.out.println(Thread.interrupted());
        System.out.println(Thread.interrupted());
        //3.演示
        Thread t3=new Thread(()->{
           while (!Thread.currentThread().isInterrupted()){
                //处理业务
               System.out.println("t3 is working...");
           }
            System.out.println("t3结束");
        });
        t3.start();
        Thread.sleep(500);
        t3.interrupt();
    }
}
