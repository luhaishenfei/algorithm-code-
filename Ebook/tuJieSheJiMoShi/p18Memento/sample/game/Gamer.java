package tuJieSheJiMoShi.p18Memento.sample.game;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class Gamer {
    private int money;
    private List fruits = new ArrayList();
    private Random random = new Random();
    private static String[] fruitsname = {"苹果", "橘子", "香蕉", "草莓"};

    public Gamer(int money) {
        this.money=money;
    }

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
            String f=getFruit();
            fruits.add(f);
            System.out.println("获得水果[" + f + "],余额=" + money + ",水果=" + fruits);
        } else {
            System.out.println("什么也没发生");
        }
    }

    public Memento createMemento() {
        Memento memento = new Memento(this.money);
        Iterator it = fruits.iterator();
        while (it.hasNext()){
            String f= (String) it.next();
            if (f.startsWith("好吃的")){
                memento.addFruit(f);
            }
        }
        return memento;
    }

    public void restoreMemento(Memento memento) {
        this.money = memento.getMoney();
        this.fruits = memento.getFruits();
    }

    private String getFruit() {
        String prefix="";
        if (random.nextBoolean()){
            prefix="好吃的";
        }
        return prefix+fruitsname[random.nextInt(fruitsname.length)];
    }


    @Override
    public String toString() {
        return "Gamer{" +
                "money=" + money +
                ", fruits=" + fruits +
                "}";
    }

}
