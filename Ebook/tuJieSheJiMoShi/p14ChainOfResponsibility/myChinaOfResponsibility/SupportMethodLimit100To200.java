package tuJieSheJiMoShi.p14ChainOfResponsibility.myChinaOfResponsibility;

public class SupportMethodLimit100To200 extends Support {
    public SupportMethodLimit100To200(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber()>=100&&trouble.getNumber()<=200) {
            return true;
        } else {
            return false;
        }
    }
}
