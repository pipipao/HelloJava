package GUI_test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloTimerGUI {
    public static void main(String[] args) {
        background();
//        show();

    }

    public static void background() {
        JFrame mainframe = new JFrame();
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel cp = (JPanel) mainframe.getContentPane();
        cp.setLayout(new BorderLayout());
        ImageIcon background = new ImageIcon("/Users/dukaixuan/IdeaProjects/HelloJava/src/GUI_test/background.jpeg");
        JLabel label=new JLabel(background);
        cp.add("Center", label);
        //**************************
//
//        Font font = new Font(Font.DIALOG, Font.BOLD, 80);
//        JLabel time = new JLabel("00:00:00");
//
//        Font metionFont = new Font(Font.DIALOG, Font.BOLD, 400);
//        JLabel metion = new JLabel("莫忘签到");
//
//        metion.setFont(metionFont);
//        time.setFont(font);

        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainframe.dispose();
                System.exit(1);
            }

        };
        mainframe.getRootPane().registerKeyboardAction(actionListener, "command",
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_IN_FOCUSED_WINDOW);

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getDefaultScreenDevice();
        gd.setFullScreenWindow(mainframe);


//        jframe.add(fullsButton);
//        jframe.add(exitButton);
//        mainframe.add(time);
//        mainframe.add(metion);
//        cp.add(time);
//        cp.add(metion);
        mainframe.setLayout(new FlowLayout());
        mainframe.pack();
//        jframe.setSize(400, 300);
        mainframe.setVisible(true);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for (int i = 0; i < 1; i++) {
            for (int j = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Date date = new Date();
                SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd:HHmmss");
                SimpleDateFormat timeFt = new SimpleDateFormat("HH:mm:ss");
                System.out.println(f.format(date));
//                mainframe.setTitle(f.format(date));
//                time.setText(timeFt.format(date));
            }
        }
        System.exit(0);

// ************************************
//        mainframe.pack();
//        mainframe.setVisible(true);
    }

    public static void show() {
        final JFrame jframe = new JFrame();
        JButton fullsButton = new JButton("全屏显示");
        JButton exitButton = new JButton("退出");
        Font font = new Font(Font.DIALOG, Font.BOLD, 80);
        JLabel time = new JLabel("00:00:00");

        Font metionFont = new Font(Font.DIALOG, Font.BOLD, 300);
        JLabel metion = new JLabel("莫忘签到");
        metion.setFont(metionFont);
        time.setFont(font);
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(1);
            }
        });
        fullsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                //通过调用GraphicsEnvironment的getDefaultScreenDevice方法获得当前的屏幕设备了
                GraphicsDevice gd = ge.getDefaultScreenDevice();
                // 全屏设置
                gd.setFullScreenWindow(jframe);
            }
        });

        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jframe.dispose();
                System.exit(1);
            }

        };
        jframe.getRootPane().registerKeyboardAction(actionListener, "command",
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_IN_FOCUSED_WINDOW);

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getDefaultScreenDevice();
        gd.setFullScreenWindow(jframe);


//        jframe.add(fullsButton);
//        jframe.add(exitButton);
        jframe.add(time);
        jframe.add(metion);
        jframe.setLayout(new FlowLayout());
//        jframe.pack();
//        jframe.setSize(400, 300);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for (int i = 0; i < 1; i++) {
            for (int j = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Date date = new Date();
                SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd:HHmmss");
                SimpleDateFormat timeFt = new SimpleDateFormat("HH:mm:ss");
                System.out.println(f.format(date));
                jframe.setTitle(f.format(date));
                time.setText(timeFt.format(date));
            }
        }
        System.exit(0);

    }
}
