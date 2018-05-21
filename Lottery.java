import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Lottery extends JFrame {

    private JButton generate = new JButton("產生");
    private JButton b2 = new JButton("離開");
    private JLabel lab[] = new JLabel[6];
    private Container cp;
    private JPanel jpnmain = new JPanel(new GridLayout(1,6,2,2));
    private JPanel jpnoption = new JPanel(new GridLayout(1,2,2,2));
    private static int number[] = new int[6];

    public Lottery(){
        init();
    }

    private void init(){

        //設定視窗資訊
        this.setBounds(200,200,800,200);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(2,2));
        cp.add(jpnmain , BorderLayout.CENTER);
        cp.add(jpnoption , BorderLayout.SOUTH);

        //設定六個標籤
        Generate_Random_Number();
        for (int i = 0 ; i < 6 ; i++){
            lab[i] = new JLabel(Integer.toString(number[i]));
            lab[i].setBackground(new Color(100, 236,255));
            lab[i].setOpaque(true);
            lab[i].setFont(new Font(Font.DIALOG , Font.PLAIN , 40));
            jpnmain.add(lab[i]);
        }

        //設定生成按鈕資訊
        generate.setLocation(150,250);
        generate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Generate_Random_Number();
                for (int i = 0 ; i < 6 ; i++){
                    lab[i].setText(Integer.toString(number[i]));
                }
            }
        });
        jpnoption.add(generate);

        //設定離開按鈕資訊
        b2.setLocation(250 , 250);
        b2.setSize(100 , 50);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jpnoption.add(b2);
    }

    //設定產生亂數函數
    private static void Generate_Random_Number(){

        Random random = new Random();

        for (int i = 0 ; i < 6 ; i++){
            number[i] = random.nextInt(49) + 1;
            for (int j = 0 ; j < i ; j++){
                if (number[j] == number[i]){
                    while (true){
                        number[i] = random.nextInt(49) + 1;
                        if (number[j] != number[i]){
                            break;
                        }
                    }
                }
            }
        }
    }
}
