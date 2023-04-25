package tuJieSheJiMoShi.p17Observer.mySample;


import java.util.ArrayList;
import java.util.Iterator;

public abstract class NumberGenerator {
    ArrayList<Observer> observers = new ArrayList<>();

    protected void addObserver(Observer observer) {
        observers.add(observer);
    }

    ;

    protected void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    ;

    void notifyObservers() {
//        for (Observer ob :
//                observers) {
//            ob.update(this);
//        }
        Iterator iterator = observers.iterator();
        while (iterator.hasNext()){
            Observer o = (Observer) iterator.next();
            o.update(this);
        }
    }


    abstract int getNumber();

    abstract void execute();
}
