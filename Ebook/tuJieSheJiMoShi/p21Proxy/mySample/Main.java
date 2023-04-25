package tuJieSheJiMoShi.p21Proxy.mySample;


public class Main {
    public static void main(String[] args) {
        PrinterProxy printerProxy = new PrinterProxy("ProxyA");
        System.out.println(printerProxy.getPrinterName());
        printerProxy.setPrinterName("zhw");
        System.out.println(printerProxy.getPrinterName());
        printerProxy.print("helloWorld");



    }
}
