public class SleepAndWait {
    /*
    区别：
    1.单词不一样
    2.sleep属于Thread类中的static方法，wait属于Object类的方法
    3.sleep属于TIME_WAITING，自动被唤醒，wait属于WAITING，需要手动唤醒才可以
    4.sleep方法在持有锁(资源)时,执行，不会释放锁资源；wait在执行后，会释放锁资源
    5.sleep方法可以在持有锁或不持有锁时,执行；wait方法必须在只有锁时，才可以执行

    wait方法必须在只有锁时，才可以执行:
    wait方法会将持有锁的线程从owner扔到WaitSet集合中，这个操作是在修改ObjectMonitor对象，
    如果没有持有synchronized锁的话，是无法操作ObjectMonitor对象的
     */
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(1);

        Object obj=new Object();
        obj.wait();
    }
}
