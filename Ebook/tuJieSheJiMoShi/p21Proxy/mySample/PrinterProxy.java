package tuJieSheJiMoShi.p21Proxy.mySample;

public class PrinterProxy implements Printable {
    //打印机名字(代理名字)
    private String name;
    //实际本人名字
    private Printer real;

    public PrinterProxy(String name) {
        this.name = name;
    }

    public synchronized void realize(String name) {
        if (real == null) {
            real = new Printer(name);
        }
    }

    @Override
    public synchronized void setPrinterName(String name) {
        if (real != null) {
            this.real.setPrinterName(name);
        }
        this.name = name;
    }

    @Override
    public String getPrinterName() {
        return this.name;
    }

    @Override
    public void print(String string) {
        realize(this.name);
        real.print(string);
    }
}
