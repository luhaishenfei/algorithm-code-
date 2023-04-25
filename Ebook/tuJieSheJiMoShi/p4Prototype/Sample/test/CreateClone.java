package tuJieSheJiMoShi.p4Prototype.Sample.test;


import tuJieSheJiMoShi.p4Prototype.A1.framework.Product;

public class CreateClone implements Cloneable{
    public Product createClone() {
        Product p=null;
        try {
            p= (Product) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
