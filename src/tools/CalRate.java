package tools;

import org.junit.Test;

public class CalRate {

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

    @Test
    public void   calRate() {
        System.out.println( calRate(5000.0, 0.015, 30));
    }
    public static double calRate(double principal,double rate,int year) {
        double amount=0;
        for (int i=0;i<year;i++){
            amount=amount+principal;
            amount=amount*(1+rate);
        }
        return amount;
    }
}
