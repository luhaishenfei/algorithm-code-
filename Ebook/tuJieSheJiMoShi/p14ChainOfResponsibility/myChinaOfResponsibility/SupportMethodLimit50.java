package tuJieSheJiMoShi.p14ChainOfResponsibility.myChinaOfResponsibility;

public class SupportMethodLimit50 extends Support {
    public SupportMethodLimit50(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber()<=50) {
            return true;
        } else {
            return false;
        }
    }
}
