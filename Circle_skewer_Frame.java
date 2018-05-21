//package Ex1070515;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Circle_skewer_Frame extends JFrame {

    //定義-------------------------------------------------------------------------------
    private JButton run = new JButton("開始遊戲");
    private JButton reset = new JButton("重新開始");
    private JButton exit = new JButton("離開");
    private JButton jbtn[][] = new JButton[3][3];
    private Container cp;
    private JPanel jpncenter = new JPanel(new GridLayout(3,3,3,3));
    private JPanel jpnright = new JPanel(new GridLayout(3,1,3,3));
    private boolean flag = true;

    //建構元-----------------------
    public Circle_skewer_Frame() {
        init();
    }

    //不回傳函數----------
    private void init() {

        //設定視窗資訊------------------------------------------------
        this.setBounds(480, 110, 960, 800);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(3,3));
        cp.add(jpncenter , BorderLayout.CENTER);
        cp.add(jpnright , BorderLayout.EAST);

        //設定開始按鈕資訊--------------------------------
        run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0 ; i < 3 ; i++) {
                    for (int j = 0 ; j < 3 ; j++){
                        jbtn[i][j].setEnabled(true);
                    }
                }
            }
        });
        jpnright.add(run);

        //設定重新按鈕資訊--------------------------------
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0 ; i < 3 ; i++){
                    for (int j = 0 ; j < 3 ; j++){
                        jbtn[i][j].setText("");
                        jbtn[i][j].setEnabled(false);
                    }
                }
            }
        });
        jpnright.add(reset);

        //設定離開按鈕資訊--------------------------------
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jpnright.add(exit);

        //設定中間的按鈕資訊-----------------------------------------------
        for (int i = 0 ; i < 3 ; i++){
            for (int j = 0 ; j < 3 ; j++){
                jbtn[i][j] = new JButton();
                jbtn[i][j].setBackground(new Color(255,255,255));
                jbtn[i][j].setEnabled(false);
                    jbtn[i][j].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton jb = (JButton) e.getSource();
                            if (jb.getText().equals("")) {
                                if (flag) {
                                    jb.setText("O");
                                } else {
                                    jb.setText("X");
                                }
                            }
                            check();
                            flag = !flag;
                        }
                    });
                jpncenter.add(jbtn[i][j]);
            }
        }
    }
    private void check() {
        for (int i = 0; i < 3; i++) {
            if (jbtn[0][i].getText().equals(jbtn[1][i].getText()) && jbtn[0][i].getText().equals(jbtn[2][i].getText()) && !jbtn[0][i].getText().equals("") && !jbtn[1][i].getText().equals("") && !jbtn[2][i].getText().equals("") ) {
                JOptionPane.showMessageDialog(Circle_skewer_Frame.this, jbtn[0][i].getText() + " 是贏家~");
                break;
            } else if (jbtn[i][0].getText().equals(jbtn[i][1].getText()) && jbtn[i][0].getText().equals(jbtn[i][2].getText()) && !jbtn[i][0].getText().equals("") && !jbtn[i][1].getText().equals("") && !jbtn[i][2].getText().equals("")) {
                JOptionPane.showMessageDialog(Circle_skewer_Frame.this, jbtn[i][0].getText() + " 是贏家~");
                break;
            }
        }
        if (jbtn[0][0].getText().equals(jbtn[1][1].getText()) && jbtn[0][0].getText().equals(jbtn[2][2].getText()) && !jbtn[0][0].getText().equals("") && !jbtn[1][1].getText().equals("") && !jbtn[2][2].getText().equals("")) {
            JOptionPane.showMessageDialog(Circle_skewer_Frame.this, jbtn[0][0].getText() + " 是贏家~");
        } else if (jbtn[0][2].getText().equals(jbtn[1][1].getText()) && jbtn[0][2].getText().equals(jbtn[2][0].getText()) && !jbtn[0][2].getText().equals("") && !jbtn[1][1].getText().equals("") && !jbtn[2][0].getText().equals("")) {
            JOptionPane.showMessageDialog(Circle_skewer_Frame.this, jbtn[0][2].getText() + " 是贏家~");
        }
    }
}
