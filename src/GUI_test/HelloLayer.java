package GUI_test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;


public class HelloLayer extends JFrame
{
    //创建一个容器
    Container ct;
    //创建背景面板。
    BackgroundPanel bgp;

    //创建一个按钮，用来证明我们的确是创建了背景图片，而不是一张图片。
    JButton jb;
    public static void main(String[] args)
    {
        new HelloLayer();
    }
    public HelloLayer()
    {
        //不采用任何布局方式。
        ct=this.getContentPane();
        this.setLayout(null);

        //在这里随便找一张400*300的照片既可以看到测试结果。
        bgp=new BackgroundPanel((new ImageIcon("/Users/dukaixuan/IdeaProjects/HelloJava/src/GUI_test/background.jpeg")).getImage());
        bgp.setBounds(0,0,2304,1440);
        ct.add(bgp);

        //创建按钮
//        jb=new JButton("测试按钮");
//        jb.setBounds(60,30,160,30);
//        ct.add(jb);
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                this.dispose();
                System.exit(1);
            }

        };
        this.getRootPane().registerKeyboardAction(actionListener, "command",
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_IN_FOCUSED_WINDOW);
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getDefaultScreenDevice();
        gd.setFullScreenWindow(this);

//        this.setSize(400,300);
//        this.setLocation(400,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
//                mainframe.setTitle(f.format(date));
//                time.setText(timeFt.format(date));
            }
        }
        System.exit(0);
    }
}
class BackgroundPanel extends JPanel
{
    Image im;
    public BackgroundPanel(Image im)
    {
        this.im=im;
        this.setOpaque(true);
    }
    //Draw the back ground.
    public void paintComponent(Graphics g)
    {
        super.paintComponents(g);
        g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);

    }
}
