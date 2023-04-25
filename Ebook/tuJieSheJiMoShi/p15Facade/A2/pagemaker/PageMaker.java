package tuJieSheJiMoShi.p15Facade.A2.pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class PageMaker {
    private PageMaker() {   // 防止外部new出PageMaker的实例，所以声明为private方法
    }

    public static void makeWelcomePage(String mailaddr, String filename) {
        try {
            Properties mailprop = Database.getProperties("maildata");
            String username = mailprop.getProperty(mailaddr);
            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
            writer.title("Welcome to " + username + "'s page!");
            writer.paragraph("欢迎来到" + username + "的主页。");
            writer.paragraph("等着你的邮件哦！");
            writer.mailto(mailaddr, username);
            writer.close();
            System.out.println(filename + " is created for " + mailaddr + " (" + username + ")");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //A1
    public static void makeLinkPage( String filename) {
        try {
            Properties mailprop = Database.getProperties("maildata");
            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
            writer.title("Link page");
            for (Object o : mailprop.keySet()) {
                writer.mailto((String) o, mailprop.getProperty((String) o));
            }
            writer.close();
            System.out.println(filename + " is created" );


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
