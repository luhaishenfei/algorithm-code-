package tuJieSheJiMoShi.p14ChainOfResponsibility.myChinaOfResponsibility;

public class SupportMethodEvenNumber extends Support {
    public SupportMethodEvenNumber(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber()%2 ==0) {
            return true;
        } else {
            return false;
        }
    }
}
