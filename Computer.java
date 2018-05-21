//package Ex1070515;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Computer extends JFrame {

    private JPanel jpnbtn = new JPanel(new GridLayout(4,5,3,3));
    private JPanel monitor = new JPanel(new GridLayout(1,1,3,3));
    private Container cp;
    private JLabel jlb = new JLabel("0",JLabel.RIGHT);
    private JButton button[] = new JButton[16];

    public Computer () {
        init();
    }
    private void init () {

        //設定視窗資訊------------------------------------------------
        this.setBounds(480, 110, 500, 600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(3,3));
        cp.add(jpnbtn , BorderLayout.CENTER);
        cp.add(monitor , BorderLayout.NORTH);

        //設定顯示答案標籤
        jlb.setFont(new Font(Font.DIALOG , Font.PLAIN , 72));
        monitor.add(jlb);

        //設定按鈕資訊
        button[0] = new JButton("7");
        button[1] = new JButton("8");
        button[2] = new JButton("9");
        button[3] = new JButton("/");
        button[4] = new JButton("4");
        button[5] = new JButton("5");
        button[6] = new JButton("6");
        button[7] = new JButton("*");
        button[8] = new JButton("1");
        button[9] = new JButton("2");
        button[10] = new JButton("3");
        button[11] = new JButton("-");
        button[12] = new JButton("0");
        button[13] = new JButton(".");
        button[14] = new JButton("=");
        button[15] = new JButton("+");
        for (int i = 0 ; i < 16 ; i++){
            button[i].setFont(new Font(Font.DIALOG , Font.PLAIN , 40));
            button[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton jb = (JButton)e.getSource();
                    jlb.setText(jlb.getText()+jb.getText());
                }
            });
            jpnbtn.add(button[i]);
        }
    }
}
