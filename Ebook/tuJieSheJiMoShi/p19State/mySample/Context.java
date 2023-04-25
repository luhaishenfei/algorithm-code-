package tuJieSheJiMoShi.p19State.mySample;

public interface Context {
    public void setClock();

    public void changeState(State state);

    void callSecurityCenter();

    void recordLog();
}
