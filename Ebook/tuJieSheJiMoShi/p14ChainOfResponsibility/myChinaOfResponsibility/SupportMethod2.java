package tuJieSheJiMoShi.p14ChainOfResponsibility.myChinaOfResponsibility;

public class SupportMethod2 extends Support {
    public SupportMethod2(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber() == 2) {
            return true;
        } else {
            return false;
        }
    }
}
