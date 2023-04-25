package tuJieSheJiMoShi.p17Observer.mySample;


public class DigitObserver implements Observer {
    @Override
    public void update(NumberGenerator generator) {
        System.out.println("DigitObserver "+generator.getNumber());
        Thread th=new Thread();
        try {
            th.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
