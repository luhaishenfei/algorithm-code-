package tools;

public class CalRate {
    public static void main(String[] args) {
        new CalRate().testRate();
    }

    public void  testRate(){
        int years=20;
        double money=2100;
//        double rax=0.1;//132305.24882942147
        double rax=0.06;//132305.24882942147

        double acount=0;

        for (int i=0;i<years;i++){
            acount=acount+money;
            acount=acount*(1+rax);
        }
        System.out.println(acount);

    }
}
