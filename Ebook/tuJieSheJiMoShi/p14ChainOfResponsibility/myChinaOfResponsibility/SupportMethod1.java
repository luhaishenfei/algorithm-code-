package tuJieSheJiMoShi.p14ChainOfResponsibility.myChinaOfResponsibility;

public class SupportMethod1 extends Support {
    public SupportMethod1(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber() == 1) {
            return true;
        } else {
            return false;
        }
    }
}
