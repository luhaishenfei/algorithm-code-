package tuJieSheJiMoShi.p18Memento.sample.game;

import java.util.ArrayList;
import java.util.List;

public class Memento {
    int money;
    ArrayList fruits;

    public int getMoney() {
        return money;
    }

    void addFruit(String fruit) {
        fruits.add(fruit);
    }

    Memento(int money) {
        this.money = money;
        this.fruits = new ArrayList();
    }

    List getFruits() {
        return (List) fruits.clone();
    }
}
