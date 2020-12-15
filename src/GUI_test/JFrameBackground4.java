package GUI_test;

/**
 * 给JFrame 添加一个背景图案。
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JFrameBackground4 extends JFrame
{
    //创建一个JLayeredPane用于分层的。
    JLayeredPane layeredPane;
    //创建一个Panel和一个Label用于存放图片，作为背景。
    JPanel jp;
    JLabel jl;

    JLabel time;
    JLabel metion;
    ImageIcon image;

    //创建一个按钮用于测试的。
    JButton jb;
    public static void main(String[] args)
    {
        new JFrameBackground4();
    }

    public JFrameBackground4()
    {
        layeredPane=new JLayeredPane();
        image=new ImageIcon("/Users/dukaixuan/IdeaProjects/HelloJava/src/GUI_test/background.jpeg");//随便找一张图就可以看到效果。
        //创建背景的那些东西
        jp=new JPanel();
        jp.setBounds(0,0,image.getIconWidth(),image.getIconHeight());

        jl=new JLabel(image);
//		jl.setBounds(0,0,image.getIconWidth(),image.getIconHeight());
        jp.add(jl);

        //创建一个测试按钮
        jb=new JButton("测试按钮");
        jb.setBounds(100,100,100,100);

        JButton jButton = new JButton("???");
//        jButton.setBounds(500,500,100,100);


        //****************
        Font font = new Font(Font.DIALOG, Font.BOLD, 80);

        time = new JLabel("00:00:00");
        time.setBackground(Color.red);
        time.setBounds(500,500,200,200);

//        Font metionFont = new Font(Font.DIALOG, Font.BOLD, 300);
//        metion = new JLabel("莫忘签到");

//        metion.setFont(metionFont);
        time.setFont(font);

        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                this.dispose();
                System.exit(1);
            }

        };
        this.getRootPane().registerKeyboardAction(actionListener, "command",
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_IN_FOCUSED_WINDOW);
        //***************8

        //将jp放到最底层。
        layeredPane.add(jp,JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(time,JLayeredPane.MODAL_LAYER);
//        layeredPane.add(metion, JLayeredPane.MODAL_LAYER);
        //将jb放到高一层的地方
        layeredPane.add(jb,JLayeredPane.MODAL_LAYER);
        layeredPane.add(jButton, JLayeredPane.MODAL_LAYER);

        this.setLayeredPane(layeredPane);
        this.setSize(image.getIconWidth(),image.getIconHeight());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(image.getIconWidth(),image.getIconHeight());
        this.setVisible(true);
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
                this.setTitle(f.format(date));
                time.setText(timeFt.format(date));
            }
        }
        System.exit(0);
    }
}