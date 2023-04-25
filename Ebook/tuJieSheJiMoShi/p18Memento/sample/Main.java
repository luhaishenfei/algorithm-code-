package tuJieSheJiMoShi.p18Memento.sample;

import tuJieSheJiMoShi.p18Memento.sample.game.Gamer;
import tuJieSheJiMoShi.p18Memento.sample.game.Memento;

public class Main {
    public static void main(String[] args) {
        Gamer gamer = new Gamer(0);
        Memento memento = gamer.createMemento();

        for (int i = 0; i < 20; i++) {
            System.out.println("===="+i);
            System.out.println(gamer.toString());

            gamer.bet();

            System.out.println("所持金钱为"+gamer.getMoney()+"元。");
            if (gamer.getMoney() < memento.getMoney()) {
                gamer.restoreMemento(memento);
                System.out.println("回退");
            } else if (gamer.getMoney() > memento.getMoney()) {
                memento = gamer.createMemento();
                System.out.println("存档");
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("最终结果"+gamer.toString());
    }
}
