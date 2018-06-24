import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

//------------執行遊戲-------------
public class Treasure_hunt_game {
    public static void main(String args[]){
        new game_menu();
    }
}

//-----------遊戲主選單-----------
class game_menu extends JFrame {

    //設定變數
    private JLabel title = new JLabel("尋寶遊戲");
    private JButton start = new JButton("快速開始");
    private JButton setting = new JButton("設定模式");
    private JButton exit = new JButton("離開遊戲");
    private JLabel background = new JLabel(new ImageIcon("material/background.jpg"));
    private JLayeredPane jlp = this.getLayeredPane();

    public game_menu () {
        init();
    }

    private void init () {

        //設定視窗資訊
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(480, 110, 960, 800);
        this.setResizable(false);
        this.setVisible(true);
        this.setLayout(null);
        this.setTitle("尋寶遊戲");
        this.setIconImage(new ImageIcon("material/game_icon.png").getImage());

        //設定背景圖片
        background.setBounds(0, 0,960,800);
        jlp.add(background,new Integer(200));

        //設定遊戲標題
        title.setBounds(278,150,404,94);
        title.setFont(new Font("微軟正黑體", Font.BOLD , 96));
        title.setForeground(Color.WHITE);
        jlp.add(title,new Integer(300));

        //設定開始按鈕
        start.setBounds(375,300,194,45);
        start.setFont(new Font("微軟正黑體", Font.BOLD , 40));
        start.setForeground(Color.RED);
        start.setFocusPainted(false);
        start.setBorderPainted(false);
        start.setContentAreaFilled(false);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new game_main(400,20, 1);
                game_menu.this.dispose();
            }
        });
        jlp.add(start,new Integer(300));

        //設定設定按鈕
        setting.setBounds(375,390,194,45);
        setting.setFont(new Font("微軟正黑體", Font.BOLD, 40));
        setting.setForeground(Color.RED);
        setting.setFocusPainted(false);
        setting.setBorderPainted(false);
        setting.setContentAreaFilled(false);
        setting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new game_setting();
                game_menu.this.dispose();
            }
        });
        jlp.add(setting,new Integer(300));

        //設定離開按鈕
        exit.setBounds(375,480,194,45);
        exit.setFont(new Font("微軟正黑體", Font.BOLD, 40));
        exit.setForeground(Color.RED);
        exit.setFocusPainted(false);
        exit.setBorderPainted(false);
        exit.setContentAreaFilled(false);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jlp.add(exit,new Integer(300));
    }
}

//---------遊戲主程式----------//
class game_main extends JFrame {

    private ImageIcon background[] = new ImageIcon[900];
    private static JLabel cloud[] = new JLabel[9216];
    private static JLabel character = new JLabel();
    private static JLabel gold_coin = new JLabel();
    private JLayeredPane jlp = this.getLayeredPane();
    private JPanel jpn = new JPanel(new GridLayout(30,30,0,0));
    private JPanel jpn_black = new JPanel(new GridLayout(96,96,0,0));
    private int count[] = {0,0};
    private static Timer ti, tifortime;
    private static int number, countforcoin = 0;
    private JLabel time = new JLabel("0");
    private static JLabel treasure = new JLabel(new ImageIcon("material/treasure.png"));
    private JLabel gold_coin_least_picture = new JLabel(new ImageIcon("gold_coin/gold_coin1.png"));
    private static JLabel gold_coin_least_word = new JLabel();

    public game_main (int radius, int step, int mode) {
        init(radius, step, mode);
    }

    private void init (int radius, int step, int mode) {

        //-----------------------設定視窗資訊-----------------------//
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(480, 40, 960, 960);
        this.setResizable(false);
        this.setVisible(true);
        this.setTitle("尋寶遊戲");
        this.setIconImage(new ImageIcon("material/game_icon.png").getImage());

        //-----------設定背景-----------//
        for (int i = 0 ; i < 900 ; i++){
            background[i] = new ImageIcon("material/grass.jpg");
            jpn.add(new JLabel(background[i]));
        }
        jpn.setBounds(0,0,960,960);
        jpn.setBackground(new Color(0,0,0));
        jpn.setOpaque(true);
        jlp.add(jpn, new Integer(200));

        //設定金幣產生
        Random random = new Random();
        gold_coin.setBounds(random.nextInt(900)+10,random.nextInt(900)+10,32,32);
        ti = new Timer(80, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (number){
                    case 0:
                        gold_coin.setIcon(new ImageIcon("gold_coin/gold_coin1.png"));
                        number = 1;
                        break;
                    case 1:
                        gold_coin.setIcon(new ImageIcon("gold_coin/gold_coin2.png"));
                        number = 2;
                        break;
                    case 2:
                        gold_coin.setIcon(new ImageIcon("gold_coin/gold_coin3.png"));
                        number = 3;
                        break;
                    case 3:
                        gold_coin.setIcon(new ImageIcon("gold_coin/gold_coin4.png"));
                        number = 4;
                        break;
                    case 4:
                        gold_coin.setIcon(new ImageIcon("gold_coin/gold_coin5.png"));
                        number = 5;
                        break;
                    case 5:
                        gold_coin.setIcon(new ImageIcon("gold_coin/gold_coin6.png"));
                        number = 6;
                        break;
                    case 6:
                        gold_coin.setIcon(new ImageIcon("gold_coin/gold_coin7.png"));
                        number = 7;
                        break;
                    case 7:
                        gold_coin.setIcon(new ImageIcon("gold_coin/gold_coin8.png"));
                        number = 8;
                        break;
                    case 8:
                        gold_coin.setIcon(new ImageIcon("gold_coin/gold_coin9.png"));
                        number = 0;
                        break;
                }
            }
        });
        jlp.add(gold_coin, new Integer(300));
        ti.start();

        //------------設定人物出生------------//
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case 27:
                        String[] options={"回到主選單","設定","結束遊戲"};
                        int jop = JOptionPane.showOptionDialog(game_main.this,"暫停中，注意:跳到其他畫面將會重置遊戲進度", "請選擇",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,"取消");
                        switch (jop){
                            case 0:
                                new game_menu().setVisible(true);
                                setVisible(false);
                                break;
                            case 1:
                                new game_setting().setVisible(true);
                                setVisible(false);
                                break;
                            case 2:
                                System.exit(0);
                        }
                        break;
                    case 37:
                        if (character.getX() - step >= 0) {
                            character.setBounds(character.getX() - step, character.getY(), character.getWidth(), character.getHeight());
                            count[1]--;
                            switch (count[1] % 4) {
                                case 0:
                                    character.setIcon(new ImageIcon("character/left1.png"));
                                    transparent(radius);
                                    gold_coin_detect();
                                    break;
                                case 1:
                                    character.setIcon(new ImageIcon("character/left2.png"));
                                    transparent(radius);
                                    gold_coin_detect();
                                    break;
                                case 2:
                                    character.setIcon(new ImageIcon("character/left3.png"));
                                    transparent(radius);
                                    gold_coin_detect();
                                    break;
                                case 3:
                                    character.setIcon(new ImageIcon("character/left4.png"));
                                    transparent(radius);
                                    gold_coin_detect();
                                    break;
                            }
                        }
                        break;
                    case 38:
                        if (character.getY() - step >= 0) {
                            character.setBounds(character.getX(), character.getY() - step, character.getWidth(), character.getHeight());
                            count[0]--;
                            switch (count[0] % 4) {
                                case 0:
                                    character.setIcon(new ImageIcon("character/back1.png"));
                                    transparent(radius);
                                    gold_coin_detect();
                                    break;
                                case 1:
                                    character.setIcon(new ImageIcon("character/back2.png"));
                                    transparent(radius);
                                    gold_coin_detect();
                                    break;
                                case 2:
                                    character.setIcon(new ImageIcon("character/back3.png"));
                                    transparent(radius);
                                    gold_coin_detect();
                                    break;
                                case 3:
                                    character.setIcon(new ImageIcon("character/back4.png"));
                                    transparent(radius);
                                    gold_coin_detect();
                                    break;
                            }
                        }
                        break;
                    case 39:
                        if (character.getX() + step <= 900) {
                            character.setBounds(character.getX() + step, character.getY(), character.getWidth(), character.getHeight());
                            count[1]++;
                            switch (count[1] % 4) {
                                case 0:
                                    character.setIcon(new ImageIcon("character/right1.png"));
                                    transparent(radius);
                                    gold_coin_detect();
                                    break;
                                case 1:
                                    character.setIcon(new ImageIcon("character/right2.png"));
                                    transparent(radius);
                                    gold_coin_detect();
                                    break;
                                case 2:
                                    character.setIcon(new ImageIcon("character/right3.png"));
                                    transparent(radius);
                                    gold_coin_detect();
                                    break;
                                case 3:
                                    character.setIcon(new ImageIcon("character/right4.png"));
                                    transparent(radius);
                                    gold_coin_detect();
                                    break;
                            }
                        }
                        break;
                    case 40:
                        if (character.getY() + step <= 810) {
                            character.setBounds(character.getX(), character.getY() + step, character.getWidth(), character.getHeight());
                            count[0]++;
                            switch (count[0] % 4) {
                                case 0:
                                    character.setIcon(new ImageIcon("character/front1.png"));
                                    transparent(radius);
                                    gold_coin_detect();
                                    break;
                                case 1:
                                    character.setIcon(new ImageIcon("character/front2.png"));
                                    transparent(radius);
                                    gold_coin_detect();
                                    break;
                                case 2:
                                    character.setIcon(new ImageIcon("character/front3.png"));
                                    transparent(radius);
                                    gold_coin_detect();
                                    break;
                                case 3:
                                    character.setIcon(new ImageIcon("character/front4.png"));
                                    transparent(radius);
                                    gold_coin_detect();
                                    break;
                            }
                        }
                        break;
                }
            }
        });
        character.setBounds(0,0,70,94);
        character.setIcon(new ImageIcon("character/front1.png"));
        jlp.add(character, new Integer(300));

        //設定黑霧
        for (int i = 0 ; i < 9216 ; i++){
            cloud[i] = new JLabel();
            cloud[i].setBackground(Color.BLACK);
            cloud[i].setOpaque(true);
            jpn_black.add(cloud[i]);
        }
        jpn_black.setBounds(0,0,960,960);
        jpn_black.setBackground(Color.BLACK);
        jpn_black.setOpaque(false);
        jlp.add(jpn_black, new Integer(400));

        //設定人物旁變透明
        transparent(radius);

        //設定目前剩下的時間
        time.setBounds(60,0,200,100);
        time.setFont(new Font("微軟正黑體", Font.BOLD , 48));
        time.setForeground(Color.WHITE);
        jlp.add(time, new Integer(500));
        tifortime = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = Integer.parseInt(time.getText());
                if (num > 0){
                    time.setText(Integer.toString(num-1));
                }else {
                    tifortime.stop();
                }
            }
        });
        tifortime.start();

        switch (mode){
            case 1:
                time.setText("180");
                gold_coin_least_word.setText("10");
                break;
            case 2:
                time.setText("90");
                gold_coin_least_word.setText("20");
                break;
            case 3:
                time.setText("30");
                gold_coin_least_word.setText("30");
                break;
        }

        //設定剩下的金幣數量
        gold_coin_least_picture.setBounds(800,20,32,32);
        gold_coin_least_word.setBounds(840,20,32,32);
        gold_coin_least_word.setFont(new Font("微軟正黑體", Font.BOLD , 24));
        gold_coin_least_word.setForeground(Color.WHITE);
        jlp.add(gold_coin_least_picture, new Integer(500));
        jlp.add(gold_coin_least_word, new Integer(500));

        //設定寶箱
        treasure.setBounds(random.nextInt(900) + 10 , random.nextInt(900) + 10 , 32 , 32);
        jlp.add(treasure , new Integer(300));
    }
    //-----------------透明函數----------------//
    private static void transparent(int radius){
        for (int i = 0 ; i < 9216 ; i++) {
            if (Math.abs(Math.sqrt(Math.pow((cloud[i].getX() - character.getX() - 35),2) + Math.pow((cloud[i].getY() - character.getY() - 47),2))) <= radius){
                cloud[i].setBackground(new Color(0,0,0,0));
            }else {
                cloud[i].setBackground(Color.BLACK);
            }
        }
    }

    //------------金幣偵測函數-------------//
    private static void gold_coin_detect(){
        Random random = new Random();
        if (character.getX() <= gold_coin.getX() && gold_coin.getX() <= character.getX() + 70 || character.getX() <= gold_coin.getX() + 32 && gold_coin.getX() + 32 <= character.getX() + 70) {
            if (character.getY() <= gold_coin.getY() && gold_coin.getY() <= character.getY() + 94 || character.getY() <= gold_coin.getY() + 32 && gold_coin.getY() + 32 <= character.getY() + 94){
                gold_coin.setLocation(random.nextInt(900) + 10, random.nextInt(900) + 10);
                int num = Integer.parseInt(gold_coin_least_word.getText());
                if (num > 0){
                    gold_coin_least_word.setText(Integer.toString(num-1));
                }else {
                    String[] options={"回到主選單","設定","結束遊戲"};
                    JOptionPane.showOptionDialog(game_main.this,"暫停中，注意:跳到其他畫面將會重置遊戲進度", "請選擇",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,"取消");
                    switch (jop){
                        case 0:
                            new game_menu().setVisible(true);
                            setVisible(false);
                            break;
                        case 1:
                            new game_setting().setVisible(true);
                            setVisible(false);
                            break;
                        case 2:
                            System.exit(0);
                    }
                }
            }
        }
        if (character.getX() <= treasure.getX() && treasure.getX() <= character.getX() + 70 || character.getX() <= treasure.getX() + 32 && treasure.getX() + 32 <= character.getX() + 70) {
            if (character.getY() <= gold_coin.getY() && treasure.getY() <= character.getY() + 94 || character.getY() <= treasure.getY() + 32 && treasure.getY() + 32 <= character.getY() + 94){
                treasure.setLocation(random.nextInt(900) + 10, random.nextInt(900) + 10);
            }
        }
    }
}

class game_setting extends JFrame {

    //設定變數
    private JLabel title = new JLabel("設定");
    private JButton easy = new JButton("簡單");
    private JButton normal = new JButton("普通");
    private JButton hard = new JButton("困難");
    private JButton backtomenu = new JButton("返回主選單");
    private JLabel background = new JLabel(new ImageIcon("material/background.jpg"));
    private JLayeredPane jlp = this.getLayeredPane();

    public game_setting () {
        init();
    }

    private void init() {

        //設定視窗資訊
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(480, 110, 960, 800);
        this.setResizable(false);
        this.setVisible(true);
        this.setLayout(null);
        this.setTitle("設定");
        this.setIconImage(new ImageIcon("material/game_icon.png").getImage());

        //設定背景圖片
        background.setBounds(0, 0,960,800);
        jlp.add(background,new Integer(200));

        //設定設定標題
        title.setBounds(384,100,192,94);
        title.setFont(new Font("微軟正黑體", Font.BOLD , 96));
        title.setForeground(Color.WHITE);
        jlp.add(title,new Integer(300));

        //設定簡單
        easy.setBounds(275,300,194,45);
        easy.setFont(new Font("微軟正黑體", Font.BOLD, 40));
        easy.setForeground(Color.GREEN);
        easy.setFocusPainted(false);
        easy.setBorderPainted(false);
        easy.setContentAreaFilled(false);
        easy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new game_main(400,20,1);
                game_setting.this.dispose();
            }
        });
        jlp.add(easy,new Integer(300));

        //設定普通
        normal.setBounds(375,300,194,45);
        normal.setFont(new Font("微軟正黑體", Font.BOLD, 40));
        normal.setForeground(Color.YELLOW);
        normal.setFocusPainted(false);
        normal.setBorderPainted(false);
        normal.setContentAreaFilled(false);
        normal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new game_main(200, 10, 2);
                game_setting.this.dispose();
            }
        });
        jlp.add(normal,new Integer(300));

        //設定困難
        hard.setBounds(475,300,194,45);
        hard.setFont(new Font("微軟正黑體", Font.BOLD, 40));
        hard.setForeground(new Color(0, 83, 255));
        hard.setFocusPainted(false);
        hard.setBorderPainted(false);
        hard.setContentAreaFilled(false);
        hard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new game_main(100,8,3);
                game_setting.this.dispose();
            }
        });
        jlp.add(hard,new Integer(300));

        //設定返回主選單
        backtomenu.setBounds(363,550,234,45);
        backtomenu.setFont(new Font("微軟正黑體", Font.BOLD, 40));
        backtomenu.setForeground(Color.RED);
        backtomenu.setFocusPainted(false);
        backtomenu.setBorderPainted(false);
        backtomenu.setContentAreaFilled(false);
        backtomenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new game_menu().setVisible(true);
                game_setting.this.setVisible(false);
            }
        });
        jlp.add(backtomenu,new Integer(300));
    }
}