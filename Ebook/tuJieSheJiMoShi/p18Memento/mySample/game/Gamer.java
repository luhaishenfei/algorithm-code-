package tuJieSheJiMoShi.p18Memento.mySample.game;


import java.util.ArrayList;
import java.util.Random;

public class Gamer {
    int money=0;
    ArrayList fruits=new ArrayList();
    private Random random=new Random();

    private static String[] fruitsname = {"苹果", "橘子", "香蕉", "草莓"};


    public int getMoney() {
        return money;
    }

    public void bet() {
        int bet = random.nextInt(6) + 1;
        if (bet == 1) {
            money++;
            System.out.println("获得1块钱，余额:" + money + ",水果=" + fruits);
        } else if (bet == 2) {
            money--;
            System.out.println("失去1块钱，余额=" + money + ",水果=" + fruits);
        } else if (bet == 6) {
            bet = random.nextInt(4);
            fruits.add(fruitsname[bet]);
            System.out.println("获得水果[" + fruitsname[bet] + "],余额=" + money + ",水果=" + fruits);
        }else {
            System.out.println("什么也没发生");
        }
    }

    public Memento createMemento() {
        Memento memento = new Memento(this.money);
        memento.fruits=this.fruits;
        return memento;
    }

    public void restoreMemento(Memento memento) {
        this.money= memento.getMoney();
        this.fruits=memento.fruits;
    }

    ArrayList getFruits() {
        return fruits;
    }


    @Override
    public String toString() {
        return "Gamer{" +
                "money=" + money +
                ", fruits=" + fruits +
                "}";
    }


}
