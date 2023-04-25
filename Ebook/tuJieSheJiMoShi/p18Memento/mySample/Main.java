package tuJieSheJiMoShi.p18Memento.mySample;

import tuJieSheJiMoShi.p18Memento.mySample.game.Gamer;
import tuJieSheJiMoShi.p18Memento.mySample.game.Memento;

public class Main {
    public static void main(String[] args) {
        Gamer gamer = new Gamer();
        Memento memento = gamer.createMemento();

        for (int i = 0; i < 20; i++) {
            gamer.bet();
            if (gamer.getMoney() < memento.getMoney()) {
                gamer.restoreMemento(memento);
                System.out.println("回退");
            } else if (gamer.getMoney() > memento.getMoney()) {
                memento = gamer.createMemento();
                System.out.println("存档");
            }
        }
        System.out.println("最终结果"+gamer.toString());
    }
}
