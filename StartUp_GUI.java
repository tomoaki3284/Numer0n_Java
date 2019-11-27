import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartUp_GUI extends JFrame {
    private JButton startBtn, loginBtn;
    private String imgPath = "";
    private Image img;

    public StartUp_GUI(){
        super();
        setBounds(400,200,850,500);

        JPanel panel = new JPanel();
        panel.setBounds(0,0,850,500);
        panel.setLayout(new BorderLayout());

        startBtn = new JButton(new AbstractAction("Start"){
            @Override
            public void actionPerformed(ActionEvent e) {
                Numeron_Prototype03 nm = new Numeron_Prototype03();
                dispose();
            }
        });

        loginBtn = new JButton(new AbstractAction("Login"){
            @Override
            public void actionPerformed(ActionEvent e) {
                //create login Dialog
            }

        });

        imgPath += Card.SharedImgPath + "Numeron01.jpg";
        try{
            img = ImageIO.read(new File(imgPath));
        }
        catch(IOException e){
            e.printStackTrace();
        }


        panel.add(startBtn, BorderLayout.SOUTH);
        panel.add(loginBtn, BorderLayout.NORTH);
        add(panel);
        repaint();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g){
        super.paint(g);

        g.drawImage(img, 0, 0, 850, 480, null);

        g.dispose();
    }
}
