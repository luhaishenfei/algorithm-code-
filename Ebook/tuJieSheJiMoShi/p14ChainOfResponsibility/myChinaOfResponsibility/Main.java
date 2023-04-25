package tuJieSheJiMoShi.p14ChainOfResponsibility.myChinaOfResponsibility;

public class Main {
    public static void main(String[] args) {

        Support sNo=new NoSupport("Loser");
        Support s1=new SupportMethod1("Job");
        Support s2=new SupportMethod2("Alice");
        Support sEvenNumber=new SupportMethodEvenNumber("Tommy");
        Support sL50=new SupportMethodLimit50("Firth");
        Support sL100To200=new SupportMethodLimit100To200("Hundred");

//
//        s1.setNext(s2);
//        s2.setNext(sEvenNumber);
        //责任链
        sNo.setNext(s1).setNext(s2).setNext(sEvenNumber).setNext(sL50).setNext(sL100To200);

        for (int i = 0; i < 300; i+=13) {
            s1.support(new Trouble(i));
        }
    }
}
