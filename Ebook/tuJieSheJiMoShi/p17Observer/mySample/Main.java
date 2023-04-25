package tuJieSheJiMoShi.p17Observer.mySample;

//Observer-Model also be called Publish-Subscribe(发布-订阅)-Model.In my opinion,Publish-Subsctibe is more correct in this model
public class Main {
    public static void main(String[] args) {
        Observer observer=new DigitObserver();
        Observer graphObserver=new GraphObserver();
        NumberGenerator numberGenerator=new RandomNumberGenerator();

        numberGenerator.addObserver(observer);
        numberGenerator.addObserver(graphObserver);
        numberGenerator.execute();
    }
}
