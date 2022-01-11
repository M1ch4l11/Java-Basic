package GuiPackages;

import GuiPercento.PercentoGui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MajkMain extends JFrame {

    private JLabel UvodText;
    private JButton button1;
    private JPanel panel1;


    public MajkMain() {
        super("Majk App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("src\\GuiPackages\\Obrazky\\ML2.jpg").getImage());
        setContentPane(panel1);
        buttonOne();
        pack();
        setCenterOfScreen();
        setVisible(true);

    }

    public void buttonOne(){
        button1.setBackground(Color.white);
        button1.setBorder(null);
        button1.setFocusPainted(false);
        button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button1.setBackground(Color.black);
                button1.setForeground(Color.white);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button1.setBackground(Color.white);
                button1.setForeground(Color.black);
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MajkMain.super.dispose();
                PercentoGui appGo = new PercentoGui();
            }
        });
    }


    public void setCenterOfScreen(){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);
    }
}
