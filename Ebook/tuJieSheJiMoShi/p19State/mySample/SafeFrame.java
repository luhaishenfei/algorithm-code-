package tuJieSheJiMoShi.p19State.mySample;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SafeFrame extends Frame implements Context, ActionListener {

    private TextField textClock = new TextField(60);
    private TextArea textScreen = new TextArea(10, 60);
    private Button buttonUse = new Button("Use");
    private Button buttonAlarm = new Button("Alarm");
    private Button buttonPhone = new Button("Phone");
    private Button buttonExit = new Button("End");

    private State state;

    public SafeFrame(String title) {
        super(title);
        setBackground(Color.lightGray);
        setLayout(new BorderLayout());
        add(textClock,BorderLayout.NORTH);
        textClock.setEditable(false);

        add(textScreen,BorderLayout.CENTER);
        textScreen.setEditable(false);

        Panel panel=new Panel();
        panel.add(buttonUse);
        panel.add(buttonAlarm);
        panel.add(buttonPhone);
        panel.add(buttonExit);

        add(panel,BorderLayout.SOUTH);

        pack();
        show();

        buttonUse.addActionListener(this);
        buttonAlarm.addActionListener(this);
        buttonPhone.addActionListener(this);
        buttonExit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        System.out.println(e.toString());
//        if (e.getSource()==buttonUse){
//            state.doUse();
//        }else if (e.getSource()==buttonAlarm){
//            state.doAlarm(this);
//        }else if (e.getSource()==button){
//            state.do
//        }else if (e.getSource()==button){
//            state.do
//        }

    }
    @Override
    public void setClock() {
    }

    @Override
    public void changeState(State state) {
        this.state = state;
    }

    @Override
    public void callSecurityCenter() {
        state.doPhone();
    }

    @Override
    public void recordLog() {
        state.doUse();
    }

}
