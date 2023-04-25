package tuJieSheJiMoShi.p4Prototype.A1.framework;

public class MessageBox extends Product {
    private char decochar;

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
}
