package tuJieSheJiMoShi.p4Prototype.A1;

import tuJieSheJiMoShi.p4Prototype.A1.framework.Manager;
import tuJieSheJiMoShi.p4Prototype.A1.framework.MessageBox;
import tuJieSheJiMoShi.p4Prototype.A1.framework.Product;

//Product类 采用Template模式
public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();

        MessageBox messageBox = new MessageBox('/');
        manager.register("mb",messageBox);
        Product mbClone = manager.create("mb");

        messageBox.use("HelloWorld");
        mbClone.use("niHao");


    }
}
