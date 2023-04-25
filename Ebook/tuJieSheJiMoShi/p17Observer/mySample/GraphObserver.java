package tuJieSheJiMoShi.p17Observer.mySample;


public class GraphObserver implements Observer {
    @Override
    public void update(NumberGenerator generator) {
        for (int i = 0; i < 5; i++) {
            if (i == 0 || i == 4) {
                System.out.println("********************");
            } else if (i == 2) {
                System.out.println("* GraphObserver " + generator.getNumber() + " *");
            } else {
                System.out.println("*                  *");
            }
        }
        System.out.println();

        Thread th = new Thread();
        try {
            th.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
