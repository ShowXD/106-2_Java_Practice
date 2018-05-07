import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Temperature_Frame extends JFrame {

    //定義
    private JButton convert = new JButton("=");
    private JButton exit = new JButton("Exit");
    private JLabel fahrenheit = new JLabel("華氏度 :");
    private JTextField input = new JTextField("0");
    private JLabel celsius = new JLabel("攝氏度");
    private JLabel answer = new JLabel("-17.78");

    public Temperature_Frame() {
        init();
    }

    private void init() {

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);

        //設定視窗資訊
        this.setLocation(100 , 50);
        this.setSize(800 , 600);

        //設定華氏標籤資訊
        fahrenheit.setBounds(50 , 60 , 60 , 30);
        this.add(fahrenheit);

        //設定輸入框框資訊
        input.setBounds(110 , 60 ,120 , 30);
        this.add(input);

        //設定轉換按鈕
        convert.setBounds(250 , 60 , 60 , 30);
        convert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answer.setText(Integer.toString((Integer.parseInt(input.getText())-32) * 5 / 9));
            }
        });
        this.add(convert);

        //設定攝氏標籤資訊
        celsius.setBounds(330 , 60 , 60 , 30);
        this.add(celsius);

        //設定輸出答案標籤
        answer.setBounds(390 , 60 , 120 , 30);
        this.add(answer);

        //設定離開按鈕
        exit.setBounds(500 , 300 , 120 , 30);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        this.add(exit);

    }
}
