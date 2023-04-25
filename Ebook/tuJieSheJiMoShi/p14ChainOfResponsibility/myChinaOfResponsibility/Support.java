package tuJieSheJiMoShi.p14ChainOfResponsibility.myChinaOfResponsibility;

public abstract class Support {
    private String name;
    private Support next;

    public Support(String name) {
        this.name = name;
    }

    public Support setNext(Support next) {
        this.next = next;
        return next;
    }

    public final void support(Trouble trouble) {
        if (resolve(trouble)) {
            done(trouble);
        } else if (next != null ) {
            next.support(trouble);
        } else {
            fail(trouble);
        }
    }

    @Override
    public String toString() {
        return "Support{" +
                "name='" + name + '\'' +
                '}';
    }

    protected abstract boolean resolve(Trouble trouble);

    protected void done(Trouble trouble) {
        System.out.println(trouble.toString() + " is resolved,resolved by "+this.toString());
    }

    protected void fail(Trouble trouble) {
        System.out.println(trouble.toString() + " resolved fail,last support by"+this.toString());
    }
}
