package tuJieSheJiMoShi.p4Prototype.Sample.test;

import Sample.framework.Manager;
import Sample.framework.Product;

public class Test {
    public static void main(String[] args) {
        Manager manager = new Manager();

        UnderLinePen underLinePen = new UnderLinePen('~');
        manager.register("ulp", underLinePen);
        Product cloneUlp = manager.create("ulp");

        underLinePen.use("HelloWorld");
        cloneUlp.use("niHao");

        System.out.println(cloneUlp == underLinePen);

        MessageBox messageBox = new MessageBox('*');
        manager.register("mb",messageBox);
        Product messageBoxClone = messageBox.createClone();

        messageBox.use("HelloWorld");
        messageBoxClone.use("niHao");

        System.out.println(messageBox==messageBoxClone);
    }
}
