import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Emoji_Frame extends JFrame {

    //定義
    private JButton jbtnleft = new JButton("<--");
    private JButton jbtnright = new JButton("-->");
    private JButton jbtnExit = new JButton("Exit");
    private JLabel jlab = new JLabel("(。・・)_且");
    private JTextField jtf = new JTextField("10");
    private int valueOf_X = 170;
    private int count = 0;

    //建構元
    public Emoji_Frame() {
        init();
    }

    //設定初始資料
    private void init() {

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);

        //設定視窗資訊
        this.setLocation(100 , 50);
        this.setSize(800 , 600);

        //設定左移按鈕資訊
        jbtnleft.setLocation(50 , 60);
        jbtnleft.setSize(120 , 30);
        jbtnleft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (count){
                    case 0:
                        jlab.setText("且_(・_・ )");
                        break;
                    case 1:
                        jlab.setText("~旦_(^O^ )");
                        break;
                    case 2:
                        jlab.setText("~~旦⊂(･∀･ )");
                        break;
                    case 3:
                        jlab.setText("~~旦_(･o･;)");
                        break;
                }
                if (count == 3) {
                    count = 0;
                }else {
                    count++;
                }
                valueOf_X -= Integer.parseInt(jtf.getText());
                jlab.setLocation(valueOf_X , 160);
            }
        });
        this.add(jbtnleft);

        //設定右移按鈕資訊
        jbtnright.setLocation(170 , 60);
        jbtnright.setSize(120 , 30);
        jbtnright.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (count){
                    case 0:
                        jlab.setText("(。・・)_且");
                        break;
                    case 1:
                        jlab.setText("(＃´ー´)旦");
                        break;
                    case 2:
                        jlab.setText("(　ﾟДﾟ)⊃旦");
                        break;
                    case 3:
                        jlab.setText("( -_-)旦~");
                        break;
                }
                if (count == 3){
                    count = 0;
                }else {
                    count++;
                }
                valueOf_X += Integer.parseInt(jtf.getText());
                jlab.setLocation(valueOf_X , 160);
            }
        });
        this.add(jbtnright);

        //設定離開按鈕資訊
        jbtnExit.setLocation(290 , 60);
        jbtnExit.setSize(120 , 30);
        jbtnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        this.add(jbtnExit);

        //設定標籤資訊
        jlab.setBounds(valueOf_X , 160 , 120 , 30);
        this.add(jlab);

        //設定輸入框框資訊
        jtf.setBounds(170 , 260 ,120 , 30);
        this.add(jtf);
    }
}
