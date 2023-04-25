package tuJieSheJiMoShi.p4Prototype.Sample.test;

import Sample.framework.Product;

public class UnderLinePen extends CreateClone implements Product {
    private char ulchar;

    public UnderLinePen() {
    }

    public UnderLinePen(char ulchar) {
        this.ulchar = ulchar;
    }

    @Override
    public void use(String s) {
        System.out.println("\""+s+"\"");
        for (int i = 0; i < s.length()+2; i++) {
            System.out.print(ulchar);
        }
        System.out.println();
    }

    @Override
    public Product createClone() {
        Product p=super.createClone();
        return p;
    }

}
