package tuJieSheJiMoShi.p4Prototype.Sample.test;

public class MessageBox extends CreateClone implements Product {
    private char decochar;

    public MessageBox() {
    }

    public MessageBox(char decochar) {
        this.decochar = decochar;
    }

    @Override
    public void use(String s) {
        for (int i = 0; i < s.length()+4; i++) {
            System.out.print(decochar);
        }
        System.out.println();

        System.out.println(decochar+" "+s+" "+decochar);

        for (int i = 0; i < s.length()+4; i++) {
            System.out.print(decochar);
        }
        System.out.println();
    }

    @Override
    public Product createClone() {
        Product p=super.createClone();
        return p;
    }

}
